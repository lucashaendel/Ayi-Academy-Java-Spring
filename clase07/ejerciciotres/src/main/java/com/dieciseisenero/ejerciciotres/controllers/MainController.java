package com.dieciseisenero.ejerciciotres.controllers;

import com.dieciseisenero.ejerciciotres.clientes.Clientes;
import com.dieciseisenero.ejerciciotres.productos.Productos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/listas")
    public String index(Model model){
        List<Productos> listaProductos = new ArrayList<>();
        listaProductos.add(new Productos(12133,"Ventilador Peabody", "Ventilador de Pie Peabody PE-VP2061", "PEABODY",46999.00f));
        listaProductos.add(new Productos(54546,"Plancha ATMA", "Plancha a Vapor ATMA PAV2339PI", "ATMA",23999.00f));
        listaProductos.add(new Productos(87807,"Pava Philips", "Pava Eléctrica Philips HD9368/00", "PHILIPS",35999.00f));
        listaProductos.add(new Productos(90987,"Licuadora Smartlife", "Licuadora de Pie Smartlife SL-BL1008WPN", "SMARTLIFE",29399.00f));
        listaProductos.add(new Productos(45451,"Pileta Mor", "Pileta de Lona Mor 1000 litros", "MOR",30399.00f));

        List<Clientes> listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes(1,"Juan Carlos","Iglesias","Avenida Colon 5000","(011) 42313546","jciglesias5000@gmail.com"));
        listaClientes.add(new Clientes(2,"Mariel Alejandra","Perez","Avenida 9 de Julio 2555","(011) 45512536","marielaperez@gmail.com"));
        listaClientes.add(new Clientes(3,"Agustina Vanesa","Varela","Avenida Rivadavia 6654","(011) 44444456","avv-2023@gmail.com"));
        listaClientes.add(new Clientes(4,"Camila","Varela","Callao 310","(011) 42354899","cami_varela@gmail.com"));
        listaClientes.add(new Clientes(5,"Facundo","Diaz","Avenida Córdoba 251","(011) 54545488","fd-freddy@gmail.com"));

        model.addAttribute("productos", listaProductos);
        model.addAttribute("clientes", listaClientes);
        model.addAttribute("title", "Lista de productos y clientes");

        return "listas";

    }
}
