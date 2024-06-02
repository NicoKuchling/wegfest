package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.QuestionnaireId;

public interface QuestionnaireRepository {

    QuestionnaireId nextIdentity();

    Questionnaire add(Questionnaire questionnaire);

    Questionnaire get(QuestionnaireId questionnaireId);
}
