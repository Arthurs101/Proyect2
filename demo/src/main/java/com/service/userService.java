//refrente a la base de datos
package com.service;

import com.service.entities.Person;
import com.service.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService{
    @Autowired
    UserRepository userRepository;
    
    public Person getPersonByUsername(String username){
         //obtener y regresar el nodo de tipo persona que tenga el mismo username
        return userRepository.findByUsername(username);
    }
}
