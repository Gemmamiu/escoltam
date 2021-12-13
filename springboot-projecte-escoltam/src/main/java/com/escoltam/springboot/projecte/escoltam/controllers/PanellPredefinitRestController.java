package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IPanellPredefinitService;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;

@RestController
@RequestMapping("/app")
public class PanellPredefinitRestController {

	@Autowired
	private IPanellPredefinitService panellPredefinitService;
	
	@Autowired 
	private IUsuariService usuariService;
	
	/**
	 * CERCA panell predefinit per id
	 * @param id
	 * @return panell predefinit
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panellPredefinit/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){

		Map<String, Object> response = new HashMap<>();
		PanellPredefinit panellPredefinit = null;

		// Control errors al realitzar la crida en la base de dades
		try {
			panellPredefinit = panellPredefinitService.findPanellPredefinitById(id);
		} catch (DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "
					+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// Control errors per si no existeix usuari que es cerca
		if (panellPredefinit == null) {
			response.put("Message", "Panell predefinit amb Id " + id + " no existeix!");
			System.out.println("El panell no existeix, codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("Cerca del panell predefinit amb id " + id + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<PanellPredefinit>(panellPredefinit, HttpStatus.OK);
	}

	/**
	 * ELIMINAR panell predefinit de l'usuari
	 * @param username que vol eliminar el panell predefinit
	 * @param id del panell predefinit
	 * @return missatge
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@DeleteMapping("/panellPredefinit/{username}/{id}")
	public ResponseEntity<?> delete(@PathVariable String username, @PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		Usuari usuari = usuariService.findByUsername(username);

		try {
			usuari.setPanellPredefinits(null);
			usuariService.save(usuari);
			
		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'eliminar el panell de la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'eliminar el panell de la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "El panell predefinit s'ha eliminat correctament");
		System.out.println("El panell predefinit s'ha eliminat correctament, codi " + HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}
}
