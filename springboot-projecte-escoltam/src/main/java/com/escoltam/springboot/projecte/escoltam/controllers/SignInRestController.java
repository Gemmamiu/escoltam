package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 * REGISTRE usuari
	 * @param usuari
	 * @return l'objecte (usuari) creat 
	 */
	@PostMapping("/signin")
	//@ResponseStatus(HttpStatus.CREATED) //Retorna codi 201 - Indicar que s'ha creat contingut
	public ResponseEntity<?> create(@RequestBody Usuari usuari) {
		
		Usuari usuariNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			
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
}
