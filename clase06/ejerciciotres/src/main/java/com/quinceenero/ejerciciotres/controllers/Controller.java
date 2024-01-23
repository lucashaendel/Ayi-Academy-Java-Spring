package com.quinceenero.ejerciciotres.controllers;

import com.quinceenero.ejerciciotres.empleados.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class Controller {

    @GetMapping
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = new LinkedList<>();

        empleados.add(new Empleado(101, "Pepe", "Argento", 7));
        empleados.add(new Empleado(205, "Moni", "Argento", 3));
        return empleados;
    }
}
