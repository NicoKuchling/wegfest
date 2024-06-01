package com.nicokuchling.wegfest.wegfest_application.scene.impl;

import com.nicokuchling.wegfest.wegfest_application.scene.SceneApi;
import com.nicokuchling.wegfest.wegfest_application.scene.TrafficSceneDTO;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficScene;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneId;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class SceneApiImpl implements SceneApi {

    private static final Logger LOG = LoggerFactory.getLogger(SceneApiImpl.class);

    private final TrafficSceneRepository trafficSceneRepository;

    @Autowired
    public SceneApiImpl(TrafficSceneRepository trafficSceneRepository) {
        this.trafficSceneRepository = trafficSceneRepository;
    }

    @Override
    public List<TrafficSceneDTO> getAllScenes() {

        List<TrafficScene> scenes = trafficSceneRepository.getAll();

        return scenes.stream().map(scene -> new TrafficSceneDTO(
                    scene.getTrafficSceneId().getId().toString(),
                    scene.getName(),
                    scene.getDescription(),
                    scene.getDifficulty()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<TrafficSceneDTO> getSceneById(UUID id) {

        LOG.debug("Trying to get scene by id: {}", id.toString());

        TrafficScene scene = trafficSceneRepository.get(new TrafficSceneId(id));

        if(scene == null) {
            return ResponseEntity.notFound().build();
        }

        LOG.debug("Found scene with id: {}", id.toString());

        return ResponseEntity.ok(new TrafficSceneDTO(
                scene.getTrafficSceneId().getId().toString(),
                scene.getName(),
                scene.getDescription(),
                scene.getDifficulty()));
    }
}
