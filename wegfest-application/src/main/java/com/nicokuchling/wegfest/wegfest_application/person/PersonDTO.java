package com.nicokuchling.wegfest.wegfest_application.person;

import java.time.LocalDate;

public final class PersonDTO {

    public final String id;

    public final String firstName;

    public final String lastName;

    public final LocalDate birthDate;

    public final String gender;

    public PersonDTO(String id, String firstName, String lastName, LocalDate birthDate, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getId() {
        return id;
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
}
