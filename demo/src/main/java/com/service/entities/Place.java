package com.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Node("PLACE")
public class Place {
    @Id private String name; //departamento
    private String sub; //municipio
    private Place() { //constructor requerido por neo4j
    }
    
    @Override
    public String toString() {
        return name;
    }
}
