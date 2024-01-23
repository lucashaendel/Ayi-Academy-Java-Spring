package com.quinceenero.ejerciciodos.controllers;

import com.quinceenero.ejerciciodos.clientes.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @GetMapping
    public Map<Integer, Cliente> obtenerClientes() {
        Map<Integer, Cliente> clientes = new HashMap<>();

        // Simulación de datos
        clientes.put(1, new Cliente(1, "Pepe", "Argento", "11994477"));
        clientes.put(2, new Cliente(2, "Moni", "Argento", "13225099"));

        return clientes;
    }
}
