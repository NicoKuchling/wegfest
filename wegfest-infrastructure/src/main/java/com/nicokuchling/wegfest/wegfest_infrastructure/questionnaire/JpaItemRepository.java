package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Item;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ItemResponse;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ItemRepository;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaItemRepository implements ItemRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Item> getAll() {

        List<ItemEntity> entities = em.createQuery(
                "select _obj_ from ItemEntity _obj_",
                    ItemEntity.class)
                .getResultList();


        return entities.stream().map(entity -> Item.of(
                new ItemId(entity.getId()),
                        entity.getQuestion(),
                        entity.getResponses()))
                .collect(Collectors.toList());
    }

    @Override
    public Item get(ItemId itemId) {

        ItemEntity entity = em.find(ItemEntity.class, itemId.getId());

        if(entity == null) {
            return null;
        } else {

            return Item.of(
                    new ItemId(entity.getId()),
                    entity.getQuestion(),
                    entity.getResponses());
        }
    }

    @Override
    public List<ItemResponse> getResponsesFor(QuestionnaireId questionnaireId) {

        List<ItemResponse> resultList = new ArrayList<>();

        Query query = em.createQuery(
                "select _obj_ from ItemResponseEntity _obj_ where _obj_.itemResponseEntityPk.questionnaireId = :questionnaireId",
                ItemResponseEntity.class
        );

        query.setParameter("questionnaireId", questionnaireId);

        @SuppressWarnings("unchecked")
        List<ItemResponseEntity> entities = query.getResultList();

        entities.forEach(entity -> {

            ItemEntity itemEntity = em.find(ItemEntity.class, entity.getItemResponseEntityPk().getItemId());

            Item item = Item.of(
                    new ItemId(itemEntity.getId()),
                    itemEntity.getQuestion(),
                    itemEntity.getResponses());

            resultList.add(ItemResponse.of(item, entity.getResponse()));
        });

        return resultList;
    }
}
