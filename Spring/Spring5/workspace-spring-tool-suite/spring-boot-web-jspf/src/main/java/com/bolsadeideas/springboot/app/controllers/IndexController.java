package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //anotacion para marcar una clase como controlador de spring
public class IndexController {
	/*Como es un tipo de peticion HTTP get se mapea con un GetMapping*/
	@GetMapping("/index")
	/*El objeto model permite pasar atributos a la vista*/
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Boot");
		return "index";
		
	}

}
