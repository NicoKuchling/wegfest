package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import java.util.Objects;

public final class ItemResponse {

    private final Item item;

    private final String choosenResponse;

    private ItemResponse(Item item, String choosenResponse) {
        this.item = item;
        this.choosenResponse = choosenResponse;
    }

    public static ItemResponse of(Item item, String response) {

        if(item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if(response == null || response.isBlank()) {
            throw new IllegalArgumentException("Response cannot be null or blank");
        }

        if(!item.getResponses().contains(response)) {
            throw new IllegalArgumentException("The chosen response is not part of the given item. Possible responses for this item are: "
                    + item.getResponses());
        }

        return new ItemResponse(item, response);
    }

    public Item getItem() {
        return item;
    }

    public String getChoosenResponse() {
        return choosenResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemResponse that = (ItemResponse) o;
        return Objects.equals(item, that.item) && Objects.equals(choosenResponse, that.choosenResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, choosenResponse);
    }

    @Override
    public String toString() {
        return "ItemResponse{" +
                "item='" + item + '\'' +
                ", response='" + choosenResponse + '\'' +
                '}';
    }
}
