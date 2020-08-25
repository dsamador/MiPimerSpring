package com.bolsadeideas.springboot.web.app.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")//Esto es para recibir parámetros por el método GET en la url
	public String param(@RequestParam(name="texto", required=false) String texto, Model model) {
		model.addAttribute("resultado", "EL texto es : " + texto);
		return "params/ver";
	}
}
