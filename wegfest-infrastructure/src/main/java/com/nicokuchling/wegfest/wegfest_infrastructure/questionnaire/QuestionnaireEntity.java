package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Questionnaire;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "QUESTIONNAIRE")
public class QuestionnaireEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "IS_TEMPLATE", nullable = false, updatable = false)
    private boolean isTemplate;

    @ElementCollection
    @CollectionTable(name = "QUESTIONNAIRE_QUESTION", joinColumns = @JoinColumn(name = "QUESTIONNAIRE_ID"))
    @Column(name = "QUESTION_ID")
    private List<UUID> questions;

    @Column(name = "PERSON_ID", nullable = true, updatable = false)
    private UUID personId;

    public QuestionnaireEntity() {}

    private QuestionnaireEntity(UUID id, boolean isTemplate, List<UUID> questions, UUID personId) {
        this.id = id;
        this.isTemplate = isTemplate;
        this.questions = questions;
        this.personId = personId;
    }

    public static QuestionnaireEntity from(Questionnaire questionnaire) {

        List<UUID> questionIds = questionnaire.getQuestions()
                .stream()
                .map(QuestionId::getId)
                .toList();

        UUID personId = questionnaire.getRespondent() == null ? null : questionnaire.getRespondent().getId();

        return new QuestionnaireEntity(
                questionnaire.getQuestionnaireId().getId(),
                questionnaire.isTemplate(),
                questionIds,
                personId);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public List<UUID> getQuestions() {
        return questions;
    }

    public void setQuestions(List<UUID> questions) {
        this.questions = questions;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }
}
