package com.nicokuchling.wegfest.wegfest_infrastructure.scene;

import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficScene;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneId;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaTrafficSceneRepository implements TrafficSceneRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TrafficScene> getAll() {

        List<TrafficSceneEntity> entities = em.createQuery(
                "select _obj_ from TrafficSceneEntity _obj_",
                TrafficSceneEntity.class)
                .getResultList();

        return entities.stream().map(entity -> new TrafficScene(
                        new TrafficSceneId(entity.getId()),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getDifficulty()))
                .collect(Collectors.toList());
    }

    @Override
    public TrafficScene get(TrafficSceneId trafficSceneId) {

        TrafficSceneEntity entity = em.find(TrafficSceneEntity.class, trafficSceneId.getId());

        if(entity == null) {
            return null;
        } else {

            return new TrafficScene(
                    new TrafficSceneId(entity.getId()),
                    entity.getName(),
                    entity.getDescription(),
                    entity.getDifficulty());
        }
    }
}
