package com.nicokuchling.wegfest.wegfest_domain.questionnaire;

import java.util.List;

public interface QuestionRepository {

    List<Question> getAll();

    Question get(QuestionId questionId);
}
