package com.dieciseisenero.ejerciciouno.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/index")
    public String mostrarTitle(Model model){
        model.addAttribute("titulo", "Ejercicio uno de AYI ACADEMY");
        return "index";
    }
}
