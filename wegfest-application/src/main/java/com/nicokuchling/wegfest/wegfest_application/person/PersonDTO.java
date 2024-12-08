package com.nicokuchling.wegfest.wegfest_application.person;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "Person")
public final class PersonDTO {

    private final String id;

    private final String firstName;

    private final String lastName;

    private final LocalDate birthDate;

    private final String gender;

    public PersonDTO(String id, String firstName, String lastName, LocalDate birthDate, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Schema(name = "id", format = "uuid", example = "9e4d8e39-4039-4e3a-85a6-149801c24246")
    public String getId() {
        return id;
    }

    @Schema(name = "firstName", example = "John")
    public String getFirstName() {
        return firstName;
    }

    @Schema(name = "lastName", example = "Doe")
    public String getLastName() {
        return lastName;
    }

    @Schema(name = "birthDate", example = "1998-03-31")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Schema(name = "gender", example = "male")
    public String getGender() {
        return gender;
    }
}
