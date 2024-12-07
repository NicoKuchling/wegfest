package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;

import java.util.List;
import java.util.Objects;

public final class Item {

    private final ItemId itemId;

    private final String question;

    private final List<String> responses;

    private Item(ItemId itemId, String question, List<String> responses) {
        this.itemId = itemId;
        this.question = question;
        this.responses = List.copyOf(responses);
    }

    public static Item of(ItemId itemId, String question, List<String> responses) {

        if(itemId == null) {
            throw new IllegalArgumentException("ItemId cannot be null");
        }

        if(question == null || question.isBlank()) {
            throw new IllegalArgumentException("Question cannot be null or blank");
        }

        if(responses == null || responses.isEmpty() || responses.size() < 2) {
            throw new IllegalArgumentException("At least two responses must be provided");
        }

        return new Item(itemId, question, responses);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemId);
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
