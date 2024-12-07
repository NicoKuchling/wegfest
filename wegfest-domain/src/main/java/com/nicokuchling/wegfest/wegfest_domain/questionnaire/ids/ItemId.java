package com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids;

import java.util.Objects;
import java.util.UUID;

public final class ItemId {

    private final UUID id;

    public ItemId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemId itemId = (ItemId) o;
        return Objects.equals(id, itemId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
