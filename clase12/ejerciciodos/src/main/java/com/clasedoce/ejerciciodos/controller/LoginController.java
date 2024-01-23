package com.clasedoce.ejerciciodos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/publico")
    public String endpointPublico(){
        return "<h1>Bienvenido al endpoint Publico</h1>";
    }

    @GetMapping("/privado")
    public String endpointPrivado(){
        return "<h1>Bienvenido al endpoint Privado</h1>";
    }
}
