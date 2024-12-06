package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

import java.util.List;

public interface QuestionnaireRepository {

    QuestionnaireId nextIdentity();

    Questionnaire add(Questionnaire questionnaire);

    Questionnaire getQuestionnaire(QuestionnaireId questionnaireId);

    List<Questionnaire> getAllQuestionnaires();

    CompletedQuestionnaire add(CompletedQuestionnaire completedQuestionnaire);

    CompletedQuestionnaire getCompletedQuestionnaire(QuestionnaireId questionnaireId);

    List<CompletedQuestionnaire> getAllCompletedQuestionnaires();
}
