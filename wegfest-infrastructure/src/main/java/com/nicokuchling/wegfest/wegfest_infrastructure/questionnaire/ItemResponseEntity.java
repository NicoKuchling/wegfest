package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.CompletedQuestionnaire;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ItemResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "COMPLETED_QUESTIONNAIRE_ITEM_RESPONSE")
public class ItemResponseEntity {

    @Id
    private ItemResponseEntityPk itemResponseEntityPk;

    @Column(name = "ITEM_RESPONSE_RESPONSE")
    private String response;

    public ItemResponseEntity() {}

    private ItemResponseEntity(ItemResponseEntityPk itemResponseEntityPk, String response) {
        this.itemResponseEntityPk = itemResponseEntityPk;
        this.response = response;
    }

    public static ItemResponseEntity of(CompletedQuestionnaire completedQuestionnaire, ItemResponse itemResponse) {
        ItemResponseEntityPk itemResponseEntityPk = new ItemResponseEntityPk(
                completedQuestionnaire.getQuestionnaireId().getId(),
                itemResponse.getItem().getItemId().getId()
        );

        return new ItemResponseEntity(itemResponseEntityPk, itemResponse.getChoosenResponse());
    }

    public ItemResponseEntityPk getItemResponseEntityPk() {
        return itemResponseEntityPk;
    }

    public void setItemResponseEntityPk(ItemResponseEntityPk itemResponseEntityPk) {
        this.itemResponseEntityPk = itemResponseEntityPk;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
