/*
Uusario en la base de datos (Nodo)
*/
package com.service.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Setter
@Getter
@Component
@Node
@AllArgsConstructor

public class Person {



  private String name;
  @Id private String UserName; //el identificador en la base de datos sera su user name
  private String Password;
  /*
  Relationships
  */ 
   
  //HashSet de personas que conoce
  @Relationship(type = "KNOWS")
  private List<Person> teammates = new ArrayList<Person>();
  @Relationship(type = "LIKES")
  private List<Quality> likes = new ArrayList<Quality>() ; //hash set de preferencia de cualidades
  @Relationship(type = "HAS")
  private List<Quality> hasQuality = new ArrayList<Quality>(); //hash set  de cualidades personales
  @Relationship(type = "LIVES")
  private Place location;
  @Relationship(type = "WANTS")
  private Genere interest;
  private Genere hasGender;
  public Person() { //constructor requerido for neo4j
    // Empty constructor required as of Neo4j API 2.0.5
  };

  
  //para agregar al set de gente que conoce
  public void knows(Person person) {
    teammates.add(person);
  }

  //regresar el set con todas las personas que conoce
  public List<Person> knows(){
    return this.teammates;
  }

  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public boolean MatchPassword(String password) {
    return this.Password.equals(password);
  }
}
