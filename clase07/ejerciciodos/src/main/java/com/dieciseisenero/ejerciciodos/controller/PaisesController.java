package com.dieciseisenero.ejerciciodos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PaisesController {

    @GetMapping("/paises")
    public String mostrarPaises(Model model){
        Map<String, Integer> paisesConCopas = new HashMap<>();
        paisesConCopas.put("Brasil", 5);
        paisesConCopas.put("Alemania", 4);
        paisesConCopas.put("Italia", 4);
        paisesConCopas.put("Argentina", 3);
        paisesConCopas.put("Uruguay", 2);
        paisesConCopas.put("Francia", 2);

        model.addAttribute("titulo", "Paises con copas del mundo");
        model.addAttribute("Paises", paisesConCopas);

        return "paises";

    }
}
