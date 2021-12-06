package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;
import com.escoltam.springboot.projecte.escoltam.models.services.IIconaService;

@RestController
@RequestMapping("/app")
public class IconaRestController {

	@Autowired
	private IIconaService iconaService;
	
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/icones/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Icona show(@PathVariable Long id){
		System.out.println("Mostra icona per id");
		return iconaService.findIconaById(id); //endpoint
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/icones/{username}/{fav}")
	@ResponseStatus(HttpStatus.OK)
	public List<Icona> listFav(@PathVariable String username, @PathVariable Boolean fav){
		System.out.println("Mostra icona per id");
		return (List<Icona>) iconaService.findIconesFav(fav, username); //endpoint
	}
	
}
