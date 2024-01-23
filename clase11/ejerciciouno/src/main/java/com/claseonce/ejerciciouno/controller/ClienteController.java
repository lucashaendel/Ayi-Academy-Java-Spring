package com.claseonce.ejerciciouno.controller;

import com.claseonce.ejerciciouno.entities.Cliente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>();

    @GetMapping(value = "/clientes-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClient(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Clientes</title></head></html>");
        sb.append("<body><h1>CLIENTES DESDE SPRINGBUILDER</h1></body></html>");
        return sb.toString();
    }

    @PostMapping("/agregar-cliente")
    public String agregarCliente(){
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNumeroCliente((listaClientes.size() + 1));
        nuevoCliente.setNombre("Pepe");
        nuevoCliente.setApellido("Argento");
        listaClientes.add(nuevoCliente);
        nuevoCliente.setNumeroCliente((listaClientes.size() + 1));
        nuevoCliente.setNombre("Moni");
        nuevoCliente.setApellido("Argento");
        listaClientes.add(nuevoCliente);
        return "Cliente Agregado correctamente";
    }

    @GetMapping("/ver-clientes")
    public List<Cliente> verClientes(){
        return listaClientes;
    }
}
