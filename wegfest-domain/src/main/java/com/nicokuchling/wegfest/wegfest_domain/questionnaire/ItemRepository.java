package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;

import java.util.List;

public interface ItemRepository {

    List<Item> getAll();

    Item get(ItemId itemId);
}
