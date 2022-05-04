package com.proyect2.demo.controller.form;

import java.util.HashMap;

import com.proyect2.demo.controller.form.model.RegisterForm;
import com.service.dto.PersonDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    private PersonDTO personDTO;//usuario actual
    @GetMapping("/user/new")
    public ModelAndView newUser(){//registrar nuevo usuario
        var params = new HashMap<String, Object>();
        PersonDTO user = new PersonDTO();
        params.put("person", user);
        return new ModelAndView("register", params);
    }
    @PostMapping("/user/save")
    public ModelAndView saveUser(){
        return new ModelAndView ("index");
    }

    @GetMapping("/user/sign")
    public ModelAndView logUser(){//registrar nuevo usuario
        var params = new HashMap<String, Object>();
        PersonDTO user = new PersonDTO();
        params.put("person", user);
        return new ModelAndView("login",params);
    }

    @PostMapping("/user/login")
    public ModelAndView loginUser(){//inicio de sesion 
        return new ModelAndView("registerPriority");
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
    @GetMapping("/index")
    public String showUserList() {
    return "index";
    }
}
    


