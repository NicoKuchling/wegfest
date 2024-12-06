package com.nicokuchling.wegfest.wegfest_application.questionnaire.impl;

import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionDTO;
import com.nicokuchling.wegfest.wegfest_application.questionnaire.QuestionnaireApi;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.Item;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ids.ItemId;
import com.nicokuchling.wegfest.wegfest_domain.questionnaire.ItemRepository;
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

    private final ItemRepository itemRepository;

    @Autowired
    public QuestionnaireApiImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<QuestionDTO> getAllQuestions() {

        LOG.debug("Trying to get all questions");

        List<Item> questions = itemRepository.getAll();

        LOG.debug("Found {} questions", questions.size());

        return questions.stream().map(item -> new QuestionDTO(
                    item.getItemId().getId().toString(),
                    item.getQuestion(),
                    item.getResponses()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<QuestionDTO> getQuestion(UUID id) {

        LOG.debug("Trying to get question with id {}", id.toString());

        Item item = itemRepository.get(new ItemId(id));

        if(item == null) {
            return ResponseEntity.notFound().build();
        }

        LOG.debug("Found question with id {}", id.toString());

        return ResponseEntity.ok(new QuestionDTO(
                item.getItemId().getId().toString(),
                item.getQuestion(),
                item.getResponses()));
    }
}
