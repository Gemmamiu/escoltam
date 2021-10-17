package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;

/**
 * Controller REST: URL per conectar, enviar dades i peticions a l'app 
 * @author Gemma Rica
 *
 */
@RestController
@RequestMapping("/api")
public class UsuariRestController {

	@Autowired
	private IUsuariService usuariService;
	
	/*
	 * LLISTAR usuaris
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris")
	public List<Usuari> index(){
		return usuariService.findAll(); //endpoint
	}
	
	/**
	 * CERCAR usuaris
	 * @param id identificador
	 * @return usuariService l'usuari amb l'identificador passat per parametre
	 */
	@GetMapping("/usuaris/{id}")
	public Usuari show(@PathVariable Long id) { 
		return usuariService.findById(id);
	}
	
}
