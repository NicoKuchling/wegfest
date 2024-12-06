package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;

import java.util.List;

public final class Item {

    private final ItemId itemId;

    private final String question;

    private final List<String> responses;

    public Item(ItemId itemId, String question, List<String> responses) {
        this.itemId = itemId;
        this.question = question;
        this.responses = List.copyOf(responses);
    }

    public ItemId getItemId() {
        return itemId;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getResponses() {
        return responses;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", question='" + question + '\'' +
                ", possibleAnswers=" + responses +
                '}';
    }
}
