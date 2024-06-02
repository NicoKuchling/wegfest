package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;

import java.util.Collections;
import java.util.List;

public final class Question {

    private final QuestionId questionId;

    private final String question;

    private final List<String> possibleAnswers;

    public Question(QuestionId questionId, String question, List<String> possibleAnswers) {
        this.questionId = questionId;
        this.question = question;
        this.possibleAnswers = List.copyOf(possibleAnswers);
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getPossibleAnswers() {
        return Collections.unmodifiableList(possibleAnswers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", possibleAnswers=" + possibleAnswers +
                '}';
    }
}
