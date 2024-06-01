package com.nicokuchling.wegfest.wegfest_domain.scene;

import java.util.UUID;

public final class TrafficSceneId {

    private final UUID id;

    public TrafficSceneId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
