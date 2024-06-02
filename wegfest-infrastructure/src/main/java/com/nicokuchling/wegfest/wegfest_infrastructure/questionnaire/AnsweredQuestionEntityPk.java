package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class AnsweredQuestionEntityPk {

    @Column(name = "QUESTIONNAIRE_ID", nullable = false, updatable = false)
    private UUID questionnaireId;

    @Column(name = "QUESTION_ID", nullable = false, updatable = false)
    private UUID questionId;

    public UUID getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(UUID questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }
}
