package com.service.dto;

import java.util.Set;

import com.service.Place;
import com.service.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDTO {
    private String name;
    private String username;
    private String password;
    private Place ubivation; 
    private Set<Person> teamates; //amigos
    

}
