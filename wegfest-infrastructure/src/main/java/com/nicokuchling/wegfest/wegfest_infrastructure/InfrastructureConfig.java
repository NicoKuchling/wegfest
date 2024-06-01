package com.nicokuchling.wegfest.wegfest_infrastructure;

import com.nicokuchling.wegfest.wegfest_domain.person.PersonRepository;
import com.nicokuchling.wegfest.wegfest_infrastructure.person.JpaPersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfig {

    @Bean
    public PersonRepository personRepository() {
        return new JpaPersonRepository();
    }
}
