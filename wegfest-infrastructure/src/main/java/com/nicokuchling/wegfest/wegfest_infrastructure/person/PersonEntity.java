package com.nicokuchling.wegfest.wegfest_infrastructure.person;

import com.nicokuchling.wegfest.wegfest_infrastructure.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "FIRST_NAME", nullable = false, updatable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, updatable = false)
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false, updatable = false)
    private LocalDate birthDate;

    @Column(name = "GENDER", nullable = false, updatable = false)
    private String gender;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean isDeleted;

    public PersonEntity() {}

    private PersonEntity(UUID id, String firstName, String lastName, LocalDate birthDate, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.isDeleted = false;
    }

    public static PersonEntity from(Person person) {

        return new PersonEntity(
                person.getPersonId().getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getGender());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
