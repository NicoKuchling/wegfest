package com.nicokuchling.wegfest.wegfest_domain.person;

import java.util.UUID;

public final class PersonId {

    private final UUID id;

    public PersonId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
