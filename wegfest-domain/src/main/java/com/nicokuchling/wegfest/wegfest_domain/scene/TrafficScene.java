package com.nicokuchling.wegfest.wegfest_domain.scene;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

public final class TrafficScene {

    private final TrafficSceneId trafficSceneId;

    private final String name;

    private final String description;

    private final String difficulty;

    private QuestionnaireId questionnaireId;

    private TrafficScene(TrafficSceneId id, String name, String description, String difficulty, QuestionnaireId questionnaireId) {
        this.trafficSceneId = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.questionnaireId = questionnaireId;
    }

    public static TrafficScene from(TrafficSceneId id, String name, String description, String difficulty, QuestionnaireId questionnaireId) {
        return new TrafficScene(id, name, description, difficulty, questionnaireId);
    }

    public TrafficSceneId getTrafficSceneId() {
        return trafficSceneId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public QuestionnaireId getQuestionnaireId() {
        return questionnaireId;
    }

    public void addOrReplaceQuestionnaire(QuestionnaireId questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public String toString() {
        return "TrafficScene{" +
                "trafficSceneId=" + trafficSceneId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", questionnaireId='" + questionnaireId + '\'' +
                '}';
    }
}
