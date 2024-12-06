package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Item;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

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

        return entities.stream().map(entity -> new Item(
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

            return new Item(
                    new ItemId(entity.getId()),
                    entity.getQuestion(),
                    entity.getResponses());
        }
    }
}
