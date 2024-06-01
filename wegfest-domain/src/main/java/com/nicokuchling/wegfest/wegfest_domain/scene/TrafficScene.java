package com.nicokuchling.wegfest.wegfest_domain.scene;

public final class TrafficScene {

    private final TrafficSceneId trafficSceneId;

    private final String name;

    private final String description;

    private final String difficulty;

    public TrafficScene(TrafficSceneId id, String name, String description, String difficulty) {
        this.trafficSceneId = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }

    public TrafficSceneId getTrafficSceneId() {
        return trafficSceneId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "TrafficScene{" +
                "trafficSceneId=" + trafficSceneId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
