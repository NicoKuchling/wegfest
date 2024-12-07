package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ItemResponseEntityPk {

    private UUID questionnaireId;

    private UUID itemId;

    public ItemResponseEntityPk() {}

    public ItemResponseEntityPk(UUID questionnaireId, UUID itemId) {
        this.questionnaireId = questionnaireId;
        this.itemId = itemId;
    }

    public UUID getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(UUID questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}
