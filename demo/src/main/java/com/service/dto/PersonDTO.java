/*
OBJETO DE TRANSFERENCIA ENTRE BASE DE DATOS Y PAGINA
*/
package com.service.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.service.entities.Person;
import com.service.entities.Place;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Password is mandatory")
    private String password;
    private Place ubivation; 
    private Set<Person> teammates;
    

}
