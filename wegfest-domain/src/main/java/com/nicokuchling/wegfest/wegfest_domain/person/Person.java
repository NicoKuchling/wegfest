package com.nicokuchling.wegfest.wegfest_domain.person;


import java.time.LocalDate;
import java.util.Objects;

/**
 * Class representing a person object. Each field must contain a value.
 */
public final class Person {

    private final PersonId personId;

    private final String firstName;

    private final String lastName;

    private final LocalDate birthDate;

    private final String gender;

    private Person(PersonId personId, String firstName, String lastName, LocalDate birthDate, String gender) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    /**
     * Static factory method for object creation.
     * <p>
     *     New instances of PersonId must be obtained with a call of the method {@link PersonRepository#nextIdentity() nextIdentity}.
     * </p>
     *
     * @param personId identifier for this object.
     * @param firstName persons first name
     * @param lastName persons last name
     * @param birthDate persons birthdate
     * @param gender persons gender
     *
     * @return new instance of Person class
     */
    public static Person from(PersonId personId, String firstName, String lastName, LocalDate birthDate, String gender) {

        if (personId == null) {
            throw new IllegalArgumentException("personId cannot be null");
        }

        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }

        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }

        if(birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }

        if(gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }

        return new Person(personId, firstName, lastName, birthDate, gender);
    }

    public PersonId getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personId);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}
