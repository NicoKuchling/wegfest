package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Question;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.QuestionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaQuestionRepository implements QuestionRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Question> getAll() {

        List<QuestionEntity> entities = em.createQuery(
                "select _obj_ from QuestionEntity _obj_",
                    QuestionEntity.class)
                .getResultList();

        return entities.stream().map(entity -> new Question(
                    new QuestionId(entity.getId()),
                    entity.getQuestion(),
                    entity.getPossibleAnswers()))
                .collect(Collectors.toList());
    }

    @Override
    public Question get(QuestionId questionId) {

        QuestionEntity entity = em.find(QuestionEntity.class, questionId.getId());

        if(entity == null) {
            return null;
        } else {

            return new Question(
                    new QuestionId(entity.getId()),
                    entity.getQuestion(),
                    entity.getPossibleAnswers());
        }
    }
}
