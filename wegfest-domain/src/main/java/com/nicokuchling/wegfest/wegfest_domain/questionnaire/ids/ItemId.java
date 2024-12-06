package com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids;

import java.util.UUID;

public final class ItemId {

    private final UUID id;

    public ItemId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
