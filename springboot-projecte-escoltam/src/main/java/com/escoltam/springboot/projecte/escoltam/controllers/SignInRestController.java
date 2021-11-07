package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;

@RestController
@RequestMapping("/")
public class SignInRestController {
	@Autowired
	private IUsuariService usuariService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//PANTALLA REGISTRE USUARI
	
	/**
	 * REGISTRE usuari
	 * @param usuari
	 * @return l'objecte (usuari) creat 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> create(@RequestBody Usuari usuari) {
		
		Usuari usuariNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			
			
			usuariNew = usuariService.save(usuari);
			usuariNew.setPassword(passwordEncoder.encode(usuariNew.getPassword()));
			usuariNew = usuariService.save(usuari);

		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de afegir usuari en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		response.put("Message", "L'usuari s'ha creat correctament");
		response.put("usuari", usuariNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//PANTALLA PER EDITAR CONTRASENYA USUARI
	
	/**
	 * EDITAR contrasenya
	 * @param usuari objecte usuari a editar
	 * @param username email de l'usuari a editar
	 * @return usuari actualitzat
	 */
	@PutMapping("/changePassword/{username}")
	public ResponseEntity<?> update(@RequestBody Usuari usuari, @PathVariable String username) {
		
		Map<String, Object> response = new HashMap<>();

		Usuari usuariActual = usuariService.findByUsername(username);
		
		Usuari usuariUpdate = null;
		
		//Control errors per si no existeix usuari que es cerca
		if (usuariActual == null) {
			response.put("Message", "Error, l'usuari no s'ha pogut editar, l'usuari " + username + " no existeix en la base de dades!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors al realitzar la crida en la base de dades
		try {
					
			usuariActual.setPassword(passwordEncoder.encode(usuari.getPassword()));
			
			usuariUpdate = usuariService.save(usuariActual);
			
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'actualitzar el client en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "L'usuari s'ha actualitzat correctament");
		response.put("usuari", usuariUpdate);
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
}
