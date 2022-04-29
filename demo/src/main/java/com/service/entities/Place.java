package com.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Place {
    @Id private String name;

    private Place() { //constructor requerido por neo4j
    }
    public Place(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
