package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Questionnaire;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.QuestionnaireRepository;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaQuestionnaireRepository implements QuestionnaireRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public QuestionnaireId nextIdentity() {
        return new QuestionnaireId(UUID.randomUUID());
    }

    @Override
    @Transactional
    public Questionnaire add(Questionnaire questionnaire) {

        QuestionnaireEntity questionnaireEntity = QuestionnaireEntity.from(questionnaire);
        em.persist(questionnaireEntity);

        if(!questionnaire.isTemplate()) {

           List<AnsweredQuestionEntity> answeredQuestionEntities = questionnaire.getAnsweredQuestions()
                   .stream()
                   .map(answeredQuestion ->
                           AnsweredQuestionEntity.of(questionnaire.getQuestionnaireId(), answeredQuestion))
                   .toList();

           answeredQuestionEntities.forEach(entity -> em.persist(entity));
        }

        return questionnaire;
    }

    @Override
    public Questionnaire get(QuestionnaireId questionnaireId) {

        QuestionnaireEntity questionnaireEntity = em.find(QuestionnaireEntity.class, questionnaireId.getId());

        if(questionnaireEntity == null) {
           return null;
        }

        Questionnaire.Builder questionnaireTemplateBuilder = new Questionnaire.Builder()
                .createQuestionnaireTemplateWithId(new QuestionnaireId(questionnaireEntity.getId()));

        questionnaireEntity.getQuestions()
                .forEach(question -> questionnaireTemplateBuilder.addQuestion(new QuestionId(question)));

        Questionnaire questionnaireTemplate = questionnaireTemplateBuilder.build();

        if(questionnaireEntity.isTemplate()) {
           return questionnaireTemplate;
        }

        List<AnsweredQuestionEntity> answeredQuestionEntities = em.createQuery(
                "select _obj_ from AnsweredQuestionEntity _obj_ where _obj_.answeredQuestionEntityPk.questionnaireId = :questionnaireId",
                    AnsweredQuestionEntity.class)
                .setParameter("questionnaireId", questionnaireEntity.getId())
                .getResultList();

        Questionnaire.Builder questionnaireBuilder = new Questionnaire.Builder()
                .createCompletedQuestionnaireOf(questionnaireTemplate, questionnaireTemplate.getQuestionnaireId())
                .addRespondent(new PersonId(questionnaireEntity.getPersonId()));

        answeredQuestionEntities.forEach(entity -> questionnaireBuilder.addAnswerToQuestion(
                new QuestionId(entity.getAnsweredQuestionEntityPk().getQuestionId()),
                entity.getAnswer()));

        return questionnaireBuilder.build();
    }
}
