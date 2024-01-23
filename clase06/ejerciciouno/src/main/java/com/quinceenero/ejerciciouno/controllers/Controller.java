package com.quinceenero.ejerciciouno.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Value("${curso.titulo}")
    private String titulo;

    @GetMapping("/titulo")
    public String obtenerTitulo() {
        return titulo;
    }

    @GetMapping("/saludo")
    public String saludar(@RequestParam(value = "nombres", defaultValue = "Usuario") String[] nombres) {
        StringBuilder mensaje = new StringBuilder("Hola ");
        for (String nombre : nombres) {
            mensaje.append(nombre).append(", ");
        }
        mensaje.delete(mensaje.length() - 2, mensaje.length());
        return mensaje.toString();
    }
}
