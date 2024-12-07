package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.person.Person;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CompletedQuestionnaire {

    private final QuestionnaireId questionnaireId;

    private final Questionnaire questionnaire;

    private final Person respondent;

    private final List<ItemResponse> chosenResponses;

    private CompletedQuestionnaire(Builder builder) {

        this.questionnaireId = builder.questionnaireId;
        this.questionnaire = builder.questionnaire;
        this.respondent = builder.respondent;
        this.chosenResponses = Collections.unmodifiableList(builder.chosenResponses);
    }

    public QuestionnaireId getQuestionnaireId() {
        return questionnaireId;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public Person getRespondent() {
        return respondent;
    }

    public List<ItemResponse> getChosenResponses() {
        return chosenResponses;
    }

    public static class Builder {
        private final QuestionnaireId questionnaireId;
        private final Questionnaire questionnaire;
        private final Person respondent;
        private final List<ItemResponse> chosenResponses;

        public Builder(QuestionnaireId questionnaireId, Questionnaire questionnaire, Person respondent) {
            this.questionnaireId = questionnaireId;
            this.questionnaire = questionnaire;
            this.respondent = respondent;
            this.chosenResponses = new ArrayList<>();
        }

        public Builder addItemResponse(ItemResponse itemResponse) {

            if(questionnaire.getItems().contains(itemResponse.getItem())) {
                chosenResponses.add(itemResponse);
            } else {
                throw new IllegalArgumentException("Item " + itemResponse.getItem() + " is not part of the corresponding questionnaire. " +
                        "The following items are part of the questionnaire: " + questionnaire.getItems());
            }

            return this;
        }

        public CompletedQuestionnaire build() {
            if(questionnaire.getItems().size() != chosenResponses.size()) {
                throw new IllegalStateException("Each item of the questionnaire must have been answered by the respondent");
            }

            return new CompletedQuestionnaire(this);
        }
    }
}
