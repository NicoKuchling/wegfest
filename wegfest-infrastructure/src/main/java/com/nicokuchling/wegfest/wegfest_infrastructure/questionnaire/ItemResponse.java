package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ItemResponse {

    private UUID itemId;

    private String response;

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
