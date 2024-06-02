package com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids;

import java.util.UUID;

public final class QuestionId {

    private final UUID id;

    public QuestionId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
