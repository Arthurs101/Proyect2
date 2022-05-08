package com.proyect2.demo.controller.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.service.Data.NE4JDB;
import com.service.dto.PersonDTO;
import com.service.entities.Person;
import com.service.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    
    private PersonDTO personDTO;//usuario actual
    private Warning warnin = new Warning();
    private final NE4JDB base = new NE4JDB("bolt://localhost:11004","neo4j","1234");

    @GetMapping("/user/new")
    public ModelAndView newUser(){//registrar nuevo usuario
        var params = new HashMap<String, Object>();
        PersonDTO user = new PersonDTO();
        params.put("person", user);
        params.put("warning", this.warnin);
        return new ModelAndView("register",params);
    }
    @PostMapping("/user/save")
    public ModelAndView saveUser(PersonDTO personDTO){//guardar nuevo usuario
        if(personDTO.getName().length() == 0){
            this.warnin = new Warning("No puede dejar campos en blanco");
            return new ModelAndView ("redirect:/user/new");
        }
        if(personDTO.getPassword().length() < 10){
            this.warnin = new Warning("La contraseña debe de tener mas de 10 caracteres");
            return new ModelAndView ("redirect:/user/new");
        }
        if(personDTO.getUsername().length() == 0){
            this.warnin = new Warning("No puede dejar campos en blanco");
            return new ModelAndView ("redirect:/user/new");
        }
        /*
        if(base.usernamaeTaken(personDTO.getUsername())){
            this.warnin = new Warning("Usuario no disponible");
            return new ModelAndView ("redirect:/user/new");
        }
        */
        boolean success = base.AddUser(personDTO);
        if (success != true){
            this.warnin = new Warning("NO SE PUDO GUARDAR EL USUARIO CORRECTAMENTE");
            return new ModelAndView ("redirect:/user/new");
        }
        return new ModelAndView ("redirect:/user/dashboard");
    }

    @GetMapping("/user/sign")
    public ModelAndView logUser(){//inicar sesion
        var params = new HashMap<String, Object>();
        PersonDTO user = new PersonDTO();
        params.put("person", user);
        params.put("warning", this.warnin);
        return new ModelAndView("login",params);
    }

    @PostMapping("/user/login")
    public ModelAndView loginUser(){//inicio de sesion 
        return new ModelAndView("registerPriority");
    }

    @GetMapping("/user/dashboard")
    public ModelAndView dashboard(){
        List<PersonDTO> testlist = new ArrayList<>();
        testlist.add(new PersonDTO("test1"));
        testlist.add(new PersonDTO("test2"));
        testlist.add(new PersonDTO("test3"));
        testlist.add(new PersonDTO("test4"));
        var params = new HashMap<String, Object>();
        params.put("listRoles", testlist );
        return new ModelAndView("userMainPanel", params);
    }

    @GetMapping("/user/dashboard/add/{id}")
    public ModelAndView addUser(@ModelAttribute("id") String id)//solicitarle al MVC ek campo ID
    {
        
        return new ModelAndView("redirect:/user/dashboard");
    }
    @GetMapping("/user/logout")
    public ModelAndView logout(){
        this.personDTO = null; //eliminar informacion de sesion temporal}
        return new ModelAndView ("index"); //regresar a inicio de sesion :p
    }
    
}
    


