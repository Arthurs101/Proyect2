package com.service.repository;
import reactor.core.publisher.Mono;

import com.service.entities.Person;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface UserRepository extends ReactiveNeo4jRepository<Person, String> {
    Mono<Person> findOneByUserName(String title);
}
