package org.repuestosgaston.app.controller;

import org.repuestosgaston.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioCotroller {

	@Autowired 
	private IUsuarioService service;
}
