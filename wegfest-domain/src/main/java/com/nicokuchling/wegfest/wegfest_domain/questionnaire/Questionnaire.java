package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Questionnaire {

    private final QuestionnaireId questionnaireId;

    private final String name;

    private final List<Item> items;

    private Questionnaire(Builder builder) {
        this.questionnaireId = builder.questionnaireId;
        this.name = builder.name;
        this.items = Collections.unmodifiableList(builder.items);
    }

    public QuestionnaireId getQuestionnaireId() {
        return questionnaireId;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class Builder {
        private final QuestionnaireId questionnaireId;
        private final String name;
        private final List<Item> items;

        public Builder(QuestionnaireId questionnaireId, String name) {
            this.questionnaireId = questionnaireId;
            this.name = name;
            this.items = new ArrayList<>();
        }

        public Builder addItem(Item item) {
            items.add(item);
            return this;
        }

        public Questionnaire build() {

            if(this.items.isEmpty()) {
                throw new IllegalStateException("Questionnaire must have at least one question");
            }

            return new Questionnaire(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire that = (Questionnaire) o;
        return Objects.equals(questionnaireId, that.questionnaireId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(questionnaireId);
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "questionnaireId=" + questionnaireId +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
