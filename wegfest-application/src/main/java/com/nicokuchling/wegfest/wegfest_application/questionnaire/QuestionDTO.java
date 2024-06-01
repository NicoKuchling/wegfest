package com.nicokuchling.wegfest.wegfest_application.questionnaire;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "Question")
public final class QuestionDTO {

    private final String id;

    private final String question;

    private final List<String> possibleAnswers;

    public QuestionDTO(String id, String question, List<String> possibleAnswers) {
        this.id = id;
        this.question = question;
        this.possibleAnswers = List.copyOf(possibleAnswers);
    }

    @Schema(name = "id", format = "uuid", example = "485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53")
    public String getId() {
        return id;
    }

    @Schema(name = "question", example = "Wie verständlich waren die Erklärungen des Tutorials?")
    public String getQuestion() {
        return question;
    }

    @ArraySchema(schema = @Schema(name = "answer", implementation = String.class, example = "Sehr verständlich"))
    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}
