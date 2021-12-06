package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IPanellService;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;


@RestController
@RequestMapping("/app")
public class PanellRestController {
	
	@Autowired
	private IPanellService panellService;
	
	@Autowired
	private IUsuariService usuariService;
	

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panells/{username}")
	@ResponseStatus(HttpStatus.OK)
	public List<Panell> index(@PathVariable String username){
		System.out.println("Mostra llistat panells");
		return panellService.findAllPanells(username); //endpoint
	}
	
	@GetMapping("/panells")
	@ResponseStatus(HttpStatus.OK)
	public List<Panell> indexs(){
		System.out.println("Mostra llistat panells");
		return panellService.findAll(); //endpoint
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panells/{username}/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Panell show(@PathVariable String username, @PathVariable Long id) {
		return panellService.findPanellByUsername(id, username);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/panells/{username}")
	@ResponseStatus(HttpStatus.CREATED)
	public Panell create(@PathVariable String username, @RequestBody Panell panell){
		
		Panell panellNew = null;
		Usuari usuari = null;
		
		usuari= usuariService.findByUsername(username);
		
		panellNew = panellService.save(panell);
		panellNew.setUsuari(usuari);
		panellNew = panellService.save(panell);
		System.out.println("Panell creat!");
		return panellNew; //endpoint
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PutMapping("/panells/{username}/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Panell update(@PathVariable String username, @PathVariable Long id, @RequestBody Panell panell){
		
		Panell panellActual = panellService.findPanellById(id);
		Panell panellUpdate = null;
		Usuari usuari = null;
		
		usuari= usuariService.findByUsername(username);
		
		
		//panellUpdate = panellService.save(panell);
		panellActual.setNom(panell.getNom());
		panellActual.setPosicio(panell.getPosicio());
		panellActual.setUsuari(usuari);
		panellUpdate = panellService.save(panellActual);
		System.out.println("Panell modificat!");
		return panellUpdate; //endpoint
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@DeleteMapping("/panells/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		System.out.println("Panell borrat!");
		panellService.delete(id); //endpoint
	}
}
