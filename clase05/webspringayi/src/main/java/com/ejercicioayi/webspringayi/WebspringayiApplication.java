package com.ejercicioayi.webspringayi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebspringayiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebspringayiApplication.class, args);
	}

	@RestController
	class SaludoController {

		@GetMapping("/")
		public String holaMundo() {
			return "Hola Mundo";
		}
	}
}
