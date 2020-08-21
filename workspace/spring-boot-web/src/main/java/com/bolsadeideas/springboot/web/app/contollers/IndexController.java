package com.bolsadeideas.springboot.web.app.contollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")//Esto es para definir una ruta raiz, es como el urls.py del settings
public class IndexController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola David Amador");
		return "index"; //Este es el archivo html que se encuentra en la carpeta templates
	}
	
	@RequestMapping("/perfil")//Por defecto toma el método GET
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("David");
		usuario.setApellido("Amador");
		usuario.setEmail("david@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
}
