package com.nicokuchling.wegfest.wegfest_infrastructure.person;

import com.nicokuchling.wegfest.wegfest_infrastructure.Person;
import com.nicokuchling.wegfest.wegfest_infrastructure.PersonId;
import com.nicokuchling.wegfest.wegfest_infrastructure.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaPersonRepository implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public PersonId nextIdentity() {
        return new PersonId(UUID.randomUUID());
    }

    @Override
    public Person add(Person person) {

        PersonEntity entity = PersonEntity.from(person);
        em.merge(entity);
        return person;
    }

    @Override
    public Person get(PersonId personId) {
        PersonEntity entity = em.find(PersonEntity.class, personId.getId());

        return new Person(
                new PersonId(entity.getId()),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getGender());
    }

    @Override
    public void remove(PersonId personId) {

        PersonEntity entity = em.find(PersonEntity.class, personId.getId());

        if(entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public List<Person> getAll() {
        List<PersonEntity> entities = em.createQuery("select _obj_ from PersonEntity _obj_", PersonEntity.class).getResultList();

        return entities.stream().map(entity ->
                new Person(
                        new PersonId(entity.getId()),
                        entity.getFirstName(),
                        entity.getLastName(),
                        entity.getBirthDate(),
                        entity.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return em.createQuery("select count(_obj_) from PersonEntity _obj_", Long.class).getSingleResult();
    }
}
