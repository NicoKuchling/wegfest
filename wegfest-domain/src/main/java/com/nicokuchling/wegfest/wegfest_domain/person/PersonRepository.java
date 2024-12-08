package com.nicokuchling.wegfest.wegfest_domain.person;

import java.util.List;

public interface PersonRepository {

    PersonId nextIdentity();

    Person add(Person person);

    Person get(PersonId personId);

    void remove(PersonId personId);

    List<Person> getAll();

    long count();
}
