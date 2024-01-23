package com.quinceenero.ejerciciocuatro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConcatenarController {
    @GetMapping("/concatenar")
    public String concatenarParametros(
            @RequestParam(value = "param1", defaultValue = "") String param1,
            @RequestParam(value = "param2", defaultValue = "") String param2,
            @RequestParam(value = "param3", defaultValue = "") String param3
    ) {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Parametro 1: ").append(param1).append("<br>");
        resultado.append("Parametro 2: ").append(param2).append("<br>");
        resultado.append("Parametro 3: ").append(param3);

        return resultado.toString();
    }
}
