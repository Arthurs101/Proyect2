package com.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Node
@AllArgsConstructor
@Getter
public class Interest {
    @Id private final String interestType;
    
}
