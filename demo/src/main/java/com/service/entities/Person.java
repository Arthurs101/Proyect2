package com.service.entities;

import java.util.Collections;
import java.util.HashSet;
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
  private Set<Person> teammates;
  @Relationship(type = "LIKES")
  private HashSet<Quality> likes = new HashSet<Quality>(); //hash set de preferencia de cualidades
  @Relationship(type = "HAS")
  private HashSet<Quality> has = new HashSet<Quality>(); //hash set  de cualidades personales
  @Relationship(type = "LIVES")
  private Place location;
  @Relationship(type = "WANTS")
  private Interest interest;
  public Person() { //constructor requerido for neo4j
    // Empty constructor required as of Neo4j API 2.0.5
  };

  
  //para agregar al set de gente que conoce
  public void knows(Person person) {
    if (teammates == null) {
      teammates = new HashSet<>();
    }
    teammates.add(person);
  }

  //regresar el set con todas las personas que conoce
  public Set<Person> knows(){
    return this.teammates;
  }

  public String toString() {

    return this.name + "'s knows => "
      + Optional.ofNullable(this.teammates).orElse(
          Collections.emptySet()).stream()
            .map(Person::getName)
            .collect(Collectors.toList());
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
