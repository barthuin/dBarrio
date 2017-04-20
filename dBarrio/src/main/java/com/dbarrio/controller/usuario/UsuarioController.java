package com.dbarrio.controller.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/newUser.do")
	public String Lista() {
		return "user/newUser";
	}
	@RequestMapping("/Formulario")
	public String Formulario() {
		return "Formulario";
	
	}
}
