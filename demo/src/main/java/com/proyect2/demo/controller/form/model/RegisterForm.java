package com.proyect2.demo.controller.form.model;

import com.service.dto.PersonDTO;

public class RegisterForm {
    private PersonDTO person;
    public void setperson(PersonDTO person) {
        this.person = person;
    }
    public PersonDTO getperson() {
        return person;
    }
}
