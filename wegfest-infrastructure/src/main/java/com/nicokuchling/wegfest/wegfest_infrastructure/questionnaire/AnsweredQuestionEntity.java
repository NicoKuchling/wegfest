package com.nicokuchling.wegfest.wegfest_infrastructure.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.javatuples.Pair;

import java.util.UUID;

@Entity
@Table(name = "ANSWERED_QUESTION")
public class AnsweredQuestionEntity {

    @EmbeddedId
    private AnsweredQuestionEntityPk answeredQuestionEntityPk;

    @Column(name = "ANSWER")
    private String answer;

    public AnsweredQuestionEntity() {}

    private AnsweredQuestionEntity(UUID questionnaireId, UUID questionId, String answer) {
        AnsweredQuestionEntityPk pk = new AnsweredQuestionEntityPk();
        pk.setQuestionnaireId(questionnaireId);
        pk.setQuestionId(questionId);

        this.answeredQuestionEntityPk = pk;
        this.answer = answer;
    }

    public static AnsweredQuestionEntity of(QuestionnaireId questionnaireId, Pair<QuestionId, String> answeredQuestion) {
        return new AnsweredQuestionEntity(
                questionnaireId.getId(),
                answeredQuestion.getValue0().getId(),
                answeredQuestion.getValue1());
    }

    public AnsweredQuestionEntityPk getAnsweredQuestionEntityPk() {
        return answeredQuestionEntityPk;
    }

    public void setAnsweredQuestionEntityPk(AnsweredQuestionEntityPk answeredQuestionEntityPk) {
        this.answeredQuestionEntityPk = answeredQuestionEntityPk;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
