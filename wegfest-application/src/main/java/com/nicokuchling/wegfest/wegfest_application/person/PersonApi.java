package com.nicokuchling.wegfest.wegfest_application.person;

import com.nicokuchling.wegfest.wegfest_domain.person.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Person API")
@RequestMapping("/person")
public interface PersonApi {

    @Operation(summary = "Get all persons", description = "Returns all available persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description="OK", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = "array", implementation = PersonDTO.class)
            ))
    })
    @GetMapping(
            value = "",
            produces = "application/json")
    List<PersonDTO> getAllPersons();

    @Operation(summary = "Get a person by id", description = "Returns a person as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PersonDTO.class)
            )),
            @ApiResponse(responseCode = "404", description = "Not found - The person was not found")
    })
    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    ResponseEntity<PersonDTO> getPersonById(@PathVariable("id") @Parameter(
                    name = "id",
                    schema = @Schema(type = "string", format = "uuid"),
                    description = "Person id",
                    example = "9e4d8e39-4039-4e3a-85a6-149801c24246") UUID id);

    @Operation(summary = "Create a person", description = "Returns the newly created person with an id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PersonDTO.class)
            ))
    })
    @PostMapping(
            value = "",
            produces = "application/json")
    ResponseEntity<PersonDTO> createPerson(@RequestBody @Parameter(
            name = "person",
            required = true,
            schema = @Schema(implementation = PersonDTO.class),
            description = "Person to be created"
    ) PersonDTO personDTO);

    @Operation(summary = "Delete a person by id", description = "Removes a person from the application as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content - Person removed successfully")
    })
    @DeleteMapping(
            value = "/{id}",
            produces = "application/json")
    ResponseEntity<Void> deletePersonById(@PathVariable("id") @Parameter(
            name = "id",
            schema = @Schema(type = "string", format = "uuid"),
            description = "Person id",
            example = "9e4d8e39-4039-4e3a-85a6-149801c24246") UUID id);
}
