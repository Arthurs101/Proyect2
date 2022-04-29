package com.service.repository;
import reactor.core.publisher.Mono;

import com.service.entities.Person;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface UserRepository extends ReactiveNeo4jRepository<Person, String> {
    @Query("MATCH (p:Person {UserName: username}) RETURN p")
    Person findByUsername(String username);
}
