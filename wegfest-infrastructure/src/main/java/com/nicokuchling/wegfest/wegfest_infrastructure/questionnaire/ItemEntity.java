package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Item;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "QUESTION")
    private String question;

    @ElementCollection
    @CollectionTable(name = "ITEM_RESPONSE", joinColumns = @JoinColumn(
            name = "ITEM_ID", referencedColumnName = "ID"
    ))
    private List<String> responses;

    public ItemEntity() {}

    private ItemEntity(UUID id, String question, List<String> responses) {
        this.id = id;
        this.question = question;
        this.responses = responses;
    }

    public static ItemEntity from(Item item) {
        return new ItemEntity(item.getItemId().getId(), item.getQuestion(), item.getResponses());
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

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
