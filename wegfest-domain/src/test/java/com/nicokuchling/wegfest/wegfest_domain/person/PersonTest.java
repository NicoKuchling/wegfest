package com.nicokuchling.wegfest.wegfest_domain.person;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void givenValidArguments_whenCreatingPerson_thenReturnValidPersonObject() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When
        Person person = Person.from(personId, firstName, lastName, birthDate, gender);

        // Then
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getLastName()).isEqualTo(lastName);
        assertThat(person.getBirthDate()).isEqualTo(birthDate);
        assertThat(person.getGender()).isEqualTo(gender);
    }

    @Test
    void givenPersonIdIsNull_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = null;
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("personId cannot be null");
    }

    @Test
    void givenFirstNameIsNull_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = null;
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First name cannot be null or empty");
    }

    @Test
    void givenFirstNameIsEmpty_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "   ";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First name cannot be null or empty");
    }

    @Test
    void givenLastNameIsNull_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = null;
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Last name cannot be null or empty");
    }

    @Test
    void givenLastNameIsEmpty_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = "";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Last name cannot be null or empty");
    }

    @Test
    void givenBirthDateIsNull_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = null;
        String gender = "male";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Birth date cannot be null");
    }

    @Test
    void givenGenderIsNull_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = null;

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gender cannot be null or empty");
    }

    @Test
    void givenGenderIsEmpty_whenCreatingPerson_thenThrowIllegalArgumentException() {
        // Given
        PersonId personId = new PersonId(UUID.randomUUID());
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(2000,1,1);
        String gender = " ";

        // When + Then
        assertThatThrownBy(() -> {
            Person person = Person.from(personId, firstName, lastName, birthDate, gender);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gender cannot be null or empty");
    }
}