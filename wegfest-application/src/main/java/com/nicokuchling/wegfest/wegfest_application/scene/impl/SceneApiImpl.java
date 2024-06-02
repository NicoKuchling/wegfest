package com.nicokuchling.wegfest.wegfest_application.scene.impl;

import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionnaireDTO;
import com.nicokuchling.wegfest.wegfest_application.scene.SceneApi;
import com.nicokuchling.wegfest.wegfest_application.scene.TrafficSceneDTO;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Questionnaire;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.QuestionnaireRepository;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficScene;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneId;
import com.nicokuchling.wegfest.wegfest_domain.scene.TrafficSceneRepository;
import org.javatuples.Pair;
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

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public SceneApiImpl(
            TrafficSceneRepository trafficSceneRepository,
            QuestionnaireRepository questionnaireRepository) {

        this.trafficSceneRepository = trafficSceneRepository;
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public List<TrafficSceneDTO> getAllScenes() {

        List<TrafficScene> scenes = trafficSceneRepository.getAll();

        return scenes.stream().map(scene -> {

            QuestionnaireDTO questionnaireDTO = createQuestionnaireDTOFor(scene.getQuestionnaireId());

            return new TrafficSceneDTO(scene.getTrafficSceneId().getId().toString(),
                            scene.getName(),
                            scene.getDescription(),
                            scene.getDifficulty(),
                            questionnaireDTO);

        }).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<TrafficSceneDTO> getSceneById(UUID id) {

        LOG.debug("Trying to get scene by id: {}", id.toString());

        TrafficScene scene = trafficSceneRepository.get(new TrafficSceneId(id));

        if(scene == null) {
            return ResponseEntity.notFound().build();
        }

        LOG.debug("Found scene with id: {}", id.toString());

        QuestionnaireDTO questionnaireDTO = createQuestionnaireDTOFor(scene.getQuestionnaireId());

        return ResponseEntity.ok(new TrafficSceneDTO(
                scene.getTrafficSceneId().getId().toString(),
                scene.getName(),
                scene.getDescription(),
                scene.getDifficulty(),
                questionnaireDTO));
    }

    @Override
    public ResponseEntity<TrafficSceneDTO> updateSceneById(UUID id, QuestionnaireDTO questionnaire) {

        LOG.debug("Trying to update scene with id: {}", id.toString());

        if(questionnaire.getRespondent() != null) {
            return ResponseEntity.badRequest().build();
        }

        if(!questionnaire.isTemplate()) {
            return ResponseEntity.badRequest().build();
        }

        if(questionnaire.getAnsweredQuestions() != null) {
            return ResponseEntity.badRequest().build();
        }

        QuestionnaireId questionnaireId = questionnaireRepository.nextIdentity();

        Questionnaire.Builder builder = new Questionnaire.Builder();
        builder.createQuestionnaireTemplateWithId(questionnaireId);

        questionnaire.getQuestionIds().forEach(questionId -> builder
                .addQuestion(new QuestionId(UUID.fromString(questionId))));

        Questionnaire newQuestionnaire = builder.build();
        questionnaireRepository.add(newQuestionnaire);

        TrafficScene scene = trafficSceneRepository.get(new TrafficSceneId(id));
        scene.addOrReplaceQuestionnaire(newQuestionnaire.getQuestionnaireId());

        trafficSceneRepository.update(scene);

        QuestionnaireDTO questionnaireDTO = createQuestionnaireDTOFor(scene.getQuestionnaireId());

        LOG.debug("New questionnaire containing {} questions created for scene with id: {}",
                questionnaireDTO.getQuestionIds().size(),
                scene.getTrafficSceneId().getId().toString());

        return ResponseEntity.ok(new TrafficSceneDTO(
                scene.getTrafficSceneId().getId().toString(),
                scene.getName(),
                scene.getDescription(),
                scene.getDifficulty(),
                questionnaireDTO
        ));
    }

    private QuestionnaireDTO createQuestionnaireDTOFor(QuestionnaireId questionnaireId) {

        if(questionnaireId.getId() == null) {
            return null;
        }

        Questionnaire questionnaire = questionnaireRepository.get(questionnaireId);

        return new QuestionnaireDTO(
                questionnaire.getQuestionnaireId().getId().toString(),
                questionnaire.isTemplate(),
                questionnaire.getQuestions().stream().map(questionId -> questionId.getId().toString()).toList(),
                questionnaire.getRespondent() == null ? null : questionnaire.getRespondent().toString(),
                questionnaire.isTemplate() ? null : questionnaire.getAnsweredQuestions()
                        .stream()
                        .map(answeredQuestion -> new Pair<String, String>(
                                answeredQuestion.getValue0().getId().toString(),
                                answeredQuestion.getValue1()))
                        .toList());
    }
}
