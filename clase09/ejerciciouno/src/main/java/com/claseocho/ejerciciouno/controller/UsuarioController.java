package com.claseocho.ejerciciouno.controller;

import com.claseocho.ejerciciouno.entities.Usuario;
import com.claseocho.ejerciciouno.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;



    @GetMapping("/usuarios")
    public List<Usuario> listaDeUsuarios(Model model){
        model.addAttribute("titulo", "Listado de Usuarios");
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return usuarios;
    }
}
