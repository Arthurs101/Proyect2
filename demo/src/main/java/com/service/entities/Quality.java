package com.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Quality {

    @Id private String name;

    private Quality() { //constructor requerido por neo4j
    }
    public Quality(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
