package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "QUESTION")
public class QuestionEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "QUESTION")
    private String question;

    @ElementCollection
    @CollectionTable(name = "QUESTION_ANSWER", joinColumns = @JoinColumn(
            name = "QUESTION_ID", referencedColumnName = "ID"))
    @Column(name = "ANSWER")
    private List<String> possibleAnswers;

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

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> answers) {
        this.possibleAnswers = answers;
    }
}
