package com.nicokuchling.wegfest.wegfest_infrastructure.scene;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "TRAFFIC_SCENE")
public class TrafficSceneEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, updatable = false)
    private String description;

    @Column(name = "DIFFICULTY", nullable = false, updatable = false)
    private String difficulty;

    @Column(name = "QUESTIONNAIRE_ID", nullable = true, updatable = true)
    private UUID questionnaireId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public UUID getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(UUID questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
