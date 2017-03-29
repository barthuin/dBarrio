package com.dbarrio.controller.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/Lista")
	public String Lista() {
		return "Lista";
	}
	@RequestMapping("/Formulario")
	public String Formulario() {
		return "Formulario";
	
	}
}
