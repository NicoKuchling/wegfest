package com.nicokuchling.wegfest.wegfest_application.questionnaire;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.javatuples.Pair;

import java.util.List;

@Schema(name = "Questionnaire")
public final class QuestionnaireDTO {

    private final String id;

    private final boolean isTemplate;

    private final List<String> questionIds;

    private final String respondent;

    private final List<Pair<String, String>> answeredQuestions;

    public QuestionnaireDTO(
            String id,
            boolean isTemplate,
            List<String> questionIds,
            String respondent,
            List<Pair<String, String>> answeredQuestions) {

        this.id = id;
        this.isTemplate = isTemplate;
        this.questionIds = questionIds;
        this.respondent = respondent;
        this.answeredQuestions = answeredQuestions;
    }

    @Schema(name = "id", type = "string", format = "uuid", example = "485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53")
    public String getId() {
        return id;
    }

    @Schema(name = "isTemplate", type = "boolean", example = "true")
    public boolean isTemplate() {
        return isTemplate;
    }

    @ArraySchema(schema = @Schema(name = "questionIds", type = "string", format = "uuid", example = "485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53"))
    public List<String> getQuestionIds() {
        return questionIds;
    }

    @Schema(
            name = "respondent",
            description = "Person id reflecting the respondent of this questionnaire",
            type = "string",
            format = "uuid")
    public String getRespondent() {
        return respondent;
    }

    @ArraySchema(schema = @Schema(name = "answeredQuestions", implementation = Pair.class))
    public List<Pair<String, String>> getAnsweredQuestions() {
        return answeredQuestions;
    }
}
