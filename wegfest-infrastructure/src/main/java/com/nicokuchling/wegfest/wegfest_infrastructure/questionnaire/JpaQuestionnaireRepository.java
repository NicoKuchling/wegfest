package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.*;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class JpaQuestionnaireRepository implements QuestionnaireRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public QuestionnaireId nextIdentity() {
        return new QuestionnaireId(UUID.randomUUID());
    }

    @Override
    @Transactional
    public Questionnaire add(Questionnaire questionnaire) {

        QuestionnaireEntity questionnaireEntity = QuestionnaireEntity.from(questionnaire);
        em.persist(questionnaireEntity);

        return questionnaire;
    }

    @Override
    public Questionnaire getQuestionnaire(QuestionnaireId questionnaireId) {

        QuestionnaireEntity questionnaireEntity = em.find(QuestionnaireEntity.class, questionnaireId.getId());

        if(questionnaireEntity == null) {
           return null;
        }

        Questionnaire.Builder questionnaireBuilder =
                new Questionnaire.Builder(new QuestionnaireId(questionnaireEntity.getId()), questionnaireEntity.getName());

        List<Item> items = getItemsFor(questionnaireEntity.getItems());
        items.forEach(questionnaireBuilder::addItem);

        return questionnaireBuilder.build();
    }

    private List<Item> getItemsFor(List<UUID> itemIds) {
        List<Item> resultList = new ArrayList<>();

        for(UUID itemId : itemIds) {
            Item item = itemRepository.get(new ItemId(itemId));

            if(item != null) {
                resultList.add(item);
            } else {
                throw new IllegalStateException("Invalid item id [" + itemId + "] found");
            }
        }

        return resultList;
    }

    @Override
    public List<Questionnaire> getAllQuestionnaires() {

        List<Questionnaire> resultList = new ArrayList<>();
        Query query = em.createQuery("select _obj_ from QuestionnaireEntity _obj_", QuestionnaireEntity.class);

        @SuppressWarnings("unchecked")
        List<QuestionnaireEntity> questionnaireEntities = query.getResultList();

        for(QuestionnaireEntity questionnaireEntity : questionnaireEntities) {

            Questionnaire.Builder questionnaireBuilder =
                    new Questionnaire.Builder(new QuestionnaireId(questionnaireEntity.getId()), questionnaireEntity.getName());

            List<Item> items = getItemsFor(questionnaireEntity.getItems());
            items.forEach(questionnaireBuilder::addItem);

            resultList.add(questionnaireBuilder.build());
        }

        return resultList;
    }

    @Override
    public CompletedQuestionnaire add(CompletedQuestionnaire completedQuestionnaire) {
        return null;
    }

    @Override
    public CompletedQuestionnaire getCompletedQuestionnaire(QuestionnaireId questionnaireId) {
        return null;
    }

    @Override
    public List<CompletedQuestionnaire> getAllCompletedQuestionnaires() {
        return List.of();
    }
}
