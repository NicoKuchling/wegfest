package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;


import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Questionnaire;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "QUESTIONNAIRE")
public class QuestionnaireEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "QUESTIONNAIRE_ITEM", joinColumns = @JoinColumn(name = "QUESTIONNAIRE_ID", referencedColumnName = "ID"))
    @Column(name = "ITEM_ID")
    private List<UUID> items;

    public QuestionnaireEntity() {}

    private QuestionnaireEntity(UUID id, String name, List<UUID> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public static QuestionnaireEntity from(Questionnaire questionnaire) {

        List<UUID> itemIds = questionnaire.getItems()
                .stream()
                .map(item -> item.getItemId().getId())
                .toList();

        return new QuestionnaireEntity(
                questionnaire.getQuestionnaireId().getId(),
                questionnaire.getName(),
                itemIds);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UUID> getItems() {
        return items;
    }

    public void setItems(List<UUID> questions) {
        this.items = questions;
    }
}
