package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.CompletedQuestionnaire;
import jakarta.persistence.*;

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
    private UUID respondentId;

    public CompletedQuestionnaireEntity() {}

    private CompletedQuestionnaireEntity(UUID id, UUID questionnaireId, UUID respondentId) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.respondentId = respondentId;
    }

    public static CompletedQuestionnaireEntity of(CompletedQuestionnaire completedQuestionnaire) {
        return new CompletedQuestionnaireEntity(
                completedQuestionnaire.getQuestionnaire().getQuestionnaireId().getId(),
                completedQuestionnaire.getQuestionnaireId().getId(),
                completedQuestionnaire.getRespondent().getPersonId().getId()
        );
    }

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

    public UUID getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(UUID respondent) {
        this.respondentId = respondent;
    }
}
