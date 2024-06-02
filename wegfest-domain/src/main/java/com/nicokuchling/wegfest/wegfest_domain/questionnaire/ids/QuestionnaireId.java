package com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids;

import java.util.UUID;

public final class QuestionnaireId {

    private final UUID id;

    public QuestionnaireId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
