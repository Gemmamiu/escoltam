package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;

//Controller REST: URL per conectar, enviar dades i peticions a l'app 
@RestController
@RequestMapping("/api")
public class UsuariRestController {

	@Autowired
	private IUsuariService usuariService;
	
	@GetMapping("/usuaris")
	public List<Usuari> index(){
		return usuariService.findAll(); //endpoint
	}
}
