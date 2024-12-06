package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Item;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "QUESTION")
    private String question;

    public ItemEntity() {}

    private ItemEntity(UUID id, String question) {
        this.id = id;
        this.question = question;
    }

    public static ItemEntity from(Item item) {
        return new ItemEntity(item.getItemId().getId(), item.getQuestion());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
