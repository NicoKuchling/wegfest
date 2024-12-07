package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

import java.util.List;

public interface ItemRepository {

    List<Item> getAll();

    Item get(ItemId itemId);

    List<ItemResponse> getResponsesFor(QuestionnaireId questionnaireId);
}
