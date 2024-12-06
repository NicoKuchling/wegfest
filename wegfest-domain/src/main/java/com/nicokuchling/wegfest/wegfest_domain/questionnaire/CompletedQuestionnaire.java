package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CompletedQuestionnaire {

    private final QuestionnaireId questionnaireId;

    private final Questionnaire questionnaire;

    private final PersonId respondent;

    private final List<Pair<ItemId, String>> itemResponses;

    private CompletedQuestionnaire(
            QuestionnaireId questionnaireId,
            Questionnaire questionnaire,
            PersonId respondent,
            List<Pair<ItemId, String>> itemResponses) {

        this.questionnaireId = questionnaireId;
        this.questionnaire = questionnaire;
        this.respondent = respondent;
        this.itemResponses = Collections.unmodifiableList(itemResponses);
    }

    public QuestionnaireId getQuestionnaireId() {
        return questionnaireId;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public PersonId getRespondent() {
        return respondent;
    }

    public List<Pair<ItemId, String>> getItemResponses() {
        return itemResponses;
    }

    public static class Builder {
        private final QuestionnaireId questionnaireId;
        private final Questionnaire questionnaire;
        private final PersonId respondent;
        private final List<Pair<ItemId, String>> itemResponses;

        public Builder( QuestionnaireId questionnaireId, Questionnaire questionnaire, PersonId respondent) {
            this.questionnaireId = questionnaireId;
            this.questionnaire = questionnaire;
            this.respondent = respondent;
            this.itemResponses = new ArrayList<>();
        }

        public Builder addItemResponse(Pair<ItemId, String> itemResponse) {
            itemResponses.add(itemResponse);
            return this;
        }

        public CompletedQuestionnaire build() {
            if(questionnaire.getItems().size() != itemResponses.size()) {
                throw new IllegalStateException("Each item of the questionnaire must have been answered by the respondent");
            }

            return new CompletedQuestionnaire(questionnaireId, questionnaire, respondent, itemResponses);
        }
    }
}
