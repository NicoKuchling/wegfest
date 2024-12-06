package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "COMPLETED_QUESTIONNAIRE")
public class CompletedQuestionnaireEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "QUESTIONNAIRE_ID", nullable = false, updatable = false)
    private UUID questionnaireId;

    @Column(name = "PERSON_ID", nullable = false, updatable = false)
    private UUID respondent;

    @ElementCollection
    @CollectionTable(
            name = "COMPLETED_QUESTIONNAIRE_ITEM_RESPONSE",
            joinColumns =  @JoinColumn(name = "COMPLETED_QUESTIONNAIRE_ID", referencedColumnName = "ID"))
    private List<ItemResponse> responses;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(UUID questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public UUID getRespondent() {
        return respondent;
    }

    public void setRespondent(UUID respondent) {
        this.respondent = respondent;
    }

    public List<ItemResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<ItemResponse> responses) {
        this.responses = responses;
    }
}
