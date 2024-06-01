package com.nicokuchling.wegfest.wegfest_application.person;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {}


    public PersonService() {
    }

    public void createPerson(PersonDTO person) {

        LOG.info("Creating person: {}", person);
    }
}
