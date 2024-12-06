package com.nicokuchling.wegfest.wegfest_application.person.impl;

import com.nicokuchling.wegfest.wegfest_application.person.PersonApi;
import com.nicokuchling.wegfest.wegfest_application.person.PersonDTO;
import com.nicokuchling.wegfest.wegfest_domain.person.Person;
import com.nicokuchling.wegfest.wegfest_domain.person.PersonId;
import com.nicokuchling.wegfest.wegfest_domain.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class PersonApiImpl implements PersonApi {

    private static final Logger LOG = LoggerFactory.getLogger(PersonApiImpl.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonApiImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<PersonDTO> getAllPersons() {

        LOG.debug("Trying to get all persons");

        List<Person> persons = personRepository.getAll();

        LOG.debug("Found {} persons", persons.size());

        return persons.stream().map(person -> new PersonDTO(
                person.getPersonId().getId().toString(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getGender())).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<PersonDTO> getPersonById(UUID id) {

        LOG.debug("Trying to get person by id: {}", id.toString());

        Person person = personRepository.get(new PersonId(id));

        if(person == null) {
            return ResponseEntity.notFound().build();
        }

        LOG.debug("Found person with id: {}", id.toString());

        return ResponseEntity.ok(new PersonDTO(
                person.getPersonId().getId().toString(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getGender()));
    }

    @Override
    public ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO) {

        LOG.debug("Trying to create person");

        PersonId personId = personRepository.nextIdentity();

        Person person = Person.from(
                personId,
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.getBirthDate(),
                personDTO.getGender());

        personRepository.add(person);

        LOG.debug("Created person with id: {}", person.getPersonId().getId().toString());

        return ResponseEntity.ok(new PersonDTO(
                person.getPersonId().getId().toString(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getGender()));
    }

    @Override
    public ResponseEntity<Void> deletePersonById(UUID id) {

        LOG.debug("Delete person with id: {}", id.toString());

        personRepository.remove(new PersonId(id));

        return ResponseEntity.noContent().build();
    }
}
