package com.nicokuchling.wegfest.wegfest_application.scene;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "TrafficScene")
public final class TrafficSceneDTO {

    private final String id;

    private final String name;

    private final String description;

    private final String difficulty;

    public TrafficSceneDTO(String id, String name, String description, String difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }

    @Schema(name = "id", format="uuid", example="47992ca4-0b01-46ac-9e3f-2bf1bc451de5")
    public String getId() {
        return id;
    }

    @Schema(name = "name", example = "Einspurig ohne Hilfsmittel")
    public String getName() {
        return name;
    }

    @Schema(name = "description", example = "Überquerung einer einspurigen Straße ohne Hilfsmittel")
    public String getDescription() {
        return description;
    }

    @Schema(name = "difficulty", example = "easy")
    public String getDifficulty() {
        return difficulty;
    }
}
