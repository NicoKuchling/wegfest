package com.nicokuchling.wegfest.wegfest_application.scene;

import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionnaireDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Scene API")
@RequestMapping("/scene")
public interface SceneApi {

    @Operation(summary = "Get all scenes", description = "Returns all available scenes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = TrafficSceneDTO.class))
            ))
    })
    @GetMapping(
            value = "",
            produces = "application/json")
    List<TrafficSceneDTO> getAllScenes();

    @Operation(summary = "Get a scene by id", description = "Returns a scene as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TrafficSceneDTO.class)
            )),
            @ApiResponse(responseCode = "404", description = "Not found - The scene was not found")
    })
    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    ResponseEntity<TrafficSceneDTO> getSceneById(@PathVariable("id") @Parameter(
            name = "id",
            schema = @Schema(type = "string", format = "uuid"),
            description = "Scene id",
            example = "47992ca4-0b01-46ac-9e3f-2bf1bc451de5") UUID id);

    @PutMapping(
            value = "/{id}",
            produces = "application/json")
    ResponseEntity<TrafficSceneDTO> updateSceneById(@PathVariable("id") @Parameter(
                name = "id",
                in = ParameterIn.PATH,
                schema = @Schema(type = "string", format = "uuid"),
                description = "Scene id",
                example = "47992ca4-0b01-46ac-9e3f-2bf1bc451de5") UUID id,
            @RequestBody @Parameter(
                    name = "questionnaire",
                    required = true,
                    schema = @Schema(implementation = QuestionnaireDTO.class),
                    description = "Scene to be updated") QuestionnaireDTO questionnaire);
}
