package com.proyect2.demo.controller.form;

import java.util.HashMap;

import com.proyect2.demo.controller.form.model.RegisterForm;
import com.service.dto.PersonDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/register")
    public ModelAndView newUser(){
        RegisterForm form = new RegisterForm();
        form.setperson(new PersonDTO());
        var params = new HashMap<String, Object>();
        params.put("form", form);
        return new ModelAndView("register", params);
    }
}
