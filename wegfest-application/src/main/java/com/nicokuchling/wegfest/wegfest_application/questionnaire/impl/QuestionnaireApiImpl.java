package com.nicokuchling.wegfest.wegfest_application.questionnaire.impl;

import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionDTO;
import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionnaireApi;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Question;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.QuestionId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class QuestionnaireApiImpl implements QuestionnaireApi {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionnaireApiImpl.class);

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionnaireApiImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public List<QuestionDTO> getAllQuestions() {

        LOG.debug("Trying to get all questions");

        List<Question> questions = questionRepository.getAll();

        LOG.debug("Found {} questions", questions.size());

        return questions.stream().map(question -> new QuestionDTO(
                    question.getQuestionId().getId().toString(),
                    question.getQuestion(),
                    question.getPossibleAnswers()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<QuestionDTO> getQuestion(UUID id) {

        LOG.debug("Trying to get question with id {}", id.toString());

        Question question = questionRepository.get(new QuestionId(id));

        if(question == null) {
            return ResponseEntity.notFound().build();
        }

        LOG.debug("Found question with id {}", id.toString());

        return ResponseEntity.ok(new QuestionDTO(
                question.getQuestionId().getId().toString(),
                question.getQuestion(),
                question.getPossibleAnswers()));
    }
}
