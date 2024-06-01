package com.nicokuchling.wegfest.wegfest_application.questionnaire;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Tag(name = "Questionnaire API")
@RequestMapping("/questionnaire")
public interface QuestionnaireApi {

    @Operation(summary = "Get all questions", description = "Returns all available questions with their possible answers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = QuestionDTO.class))
            ))
    })
    @GetMapping(
            value = "/question",
            produces = "application/json")
    List<QuestionDTO> getAllQuestions();

    @Operation(summary = "Get a question by id", description = "Returns a question as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = QuestionDTO.class)
            ))
    })
    @GetMapping(
            value = "/question/{id}",
            produces = "application/json")
    ResponseEntity<QuestionDTO> getQuestion(@PathVariable("id") @Parameter(
            name = "id",
            schema = @Schema(type = "string", format = "uuid"),
            description = "Question id",
            example = "485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53") UUID id);
}
