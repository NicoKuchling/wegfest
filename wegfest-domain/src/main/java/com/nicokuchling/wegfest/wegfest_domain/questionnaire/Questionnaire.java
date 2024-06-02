package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Questionnaire {

    private final QuestionnaireId questionnaireId;

    private final boolean isTemplate;

    private final List<QuestionId> questions;

    private final PersonId respondent;

    private final List<Pair<QuestionId, String>> answeredQuestions;

    private Questionnaire(Builder builder) {
        this.questionnaireId = builder.questionnaireId;
        this.isTemplate = builder.isTemplate;
        this.questions = Collections.unmodifiableList(builder.questions);
        this.respondent = builder.respondent;
        this.answeredQuestions = builder.answeredQuestions == null ? null : Collections.unmodifiableList(builder.answeredQuestions);
    }

    public QuestionnaireId getQuestionnaireId() {
        return questionnaireId;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public List<QuestionId> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public PersonId getRespondent() {
        return respondent;
    }

    public List<Pair<QuestionId, String>> getAnsweredQuestions() {
        return Collections.unmodifiableList(answeredQuestions);
    }

    public static class Builder {
        private boolean isTemplate;
        private QuestionnaireId questionnaireId;
        private List<QuestionId> questions;
        private PersonId respondent;
        private List<Pair<QuestionId, String>> answeredQuestions;

        public Builder createQuestionnaireTemplateWithId(QuestionnaireId questionnaireId) {
            this.isTemplate = true;
            this.questionnaireId = questionnaireId;
            this.questions = new ArrayList<>();
            return this;
        }

        public Builder addQuestion(QuestionId questionId) {
            if(this.isTemplate) {
                questions.add(questionId);
                return this;
            }

            throw new IllegalStateException("Can only add questions when questionnaire to be created is a template questionnaire");
        }

        public Builder createCompletedQuestionnaireOf(Questionnaire questionnaireTemplate, QuestionnaireId newQuestionnaireId) {
            this.isTemplate = false;
            this.questionnaireId = newQuestionnaireId;
            this.questions = questionnaireTemplate.getQuestions();
            return this;
        }

        public Builder addRespondent(PersonId respondentId) {
            if(!this.isTemplate) {
                this.respondent = respondentId;
                return this;
            }

            throw new IllegalStateException("Can only add respondent when questionnaire to be created is not a template questionnaire");
        }

        public Builder addAnswerToQuestion(QuestionId questionId, String answer) {
            if(!this.isTemplate) {
                if(this.questions.contains(questionId)) {
                    this.answeredQuestions.add(new Pair<QuestionId, String>(questionId, answer));
                    return this;
                }
                throw new IllegalStateException("The underlying questionnaire template does not contain a question with id " + questionId);
            }

            throw new IllegalStateException("Can only add answers to questions when questionnaire to be created is not a template questionnaire");
        }

        public Questionnaire build() {
            if(this.isTemplate && this.questions.isEmpty()) {
                throw new IllegalStateException("Questionnaire must have at least one question");
            }

            if(!this.isTemplate && this.answeredQuestions.size() != this.questions.size()) {
                throw new IllegalStateException("Each question must have been answered");
            }

            if(!this.isTemplate && this.respondent == null) {
                throw new IllegalStateException("Questionnaire must have a respondent");
            }

            return new Questionnaire(this);
        }
    }
}
