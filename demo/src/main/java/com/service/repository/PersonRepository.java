package com.service.repository;


import java.util.List;

import com.service.entities.Genere;
import com.service.entities.Person;
import com.service.entities.Place;
import com.service.entities.Quality;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, String> {
  Person findByUserName(String username); //encontrar el nodo de la persona mediante el usuario
  List<Person> RecommendationsByQuality(Quality quality,Genere gender); //recomendaciones mediante cualidad y que tengan el genero de interes
  List<Person> RecommendationsByPlace(Place place,Genere gender); //recomendaciones mediante el uso de la ubicacion y que tengan el genero de interes
}