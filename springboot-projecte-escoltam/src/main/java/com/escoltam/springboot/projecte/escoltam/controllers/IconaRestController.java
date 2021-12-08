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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;
import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;
import com.escoltam.springboot.projecte.escoltam.models.services.IIconaService;
import com.escoltam.springboot.projecte.escoltam.models.services.IPanellService;

/**
 * Controller REST: URL per conectar, enviar dades i peticions a l'app 
 * Controller de ICONA
 * @author Gemma Rica
 *
 */
@RestController
@RequestMapping("/app")
public class IconaRestController {

	@Autowired
	private IIconaService iconaService;
	
	@Autowired
	private IPanellService panellService;
	
	/**
	 * CERCAR icona per id
	 * @param id
	 * @return icona
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/icones/icona/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Icona icona = null;
		Map<String, Object> response = new HashMap<>();
		
		// Control errors al realitzar la crida en la base de dades
		try {
			icona = iconaService.findIconaById(id);
		} catch (DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "
					+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Cerca d'icona amb id " + id + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<Icona>(icona, HttpStatus.OK);
	}
	
	/**
	 * AFEGIR icona dins de panell
	 * @param id panell
	 * @param icona RequestBody
	 * @return icona
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/icones/icona/panell/{id}")
	public ResponseEntity<?> create(@PathVariable Long id, @RequestBody Icona icona){
		
		Map<String, Object> response = new HashMap<>();
		Panell panell = panellService.findPanellById(id);
		Icona iconaNew = null;
		Icona iconaAmbPanell= null;
		
		try {
			
			iconaNew = iconaService.save(icona);
			iconaNew.setPanell(panell);
			
			iconaAmbPanell = iconaService.save(iconaNew);
			
		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de afegir icona en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de afegir icona en la base de dades, codi: " + HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", "La icona s'ha creat correctament");
		response.put("icona", iconaAmbPanell);
		
		System.out.println("La icona s'ha creat correctament, codi: " + HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * EDITAR icona
	 * @param id icona
	 * @param icona RequestBody
	 * @return icona editada
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PutMapping("/icones/icona/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Icona icona){
		
		Map<String, Object> response = new HashMap<>();
		Icona iconaActual = iconaService.findIconaById(id);
		Icona iconaUpdate = null;
		
		// Control errors per si no existeix panell que es cerca
		if (iconaActual == null) {
			response.put("Message",
					"Error, la icona no s'ha pogut editar, icona amb id " + id + " no existeix en la base de dades!");
			System.out.println("Error, la icona no s'ha pogut editar, icona amb " + id
					+ " no existeix en la base de dades! " + "Codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		// Control errors al realitzar la crida en la base de dades
		try {

			iconaActual.setNom(icona.getNom());
			iconaActual.setPosicio(icona.getPosicio());
			iconaUpdate = iconaService.save(iconaActual);

		} catch (DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'actualitzar la icona en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'actualitzar la icona en la base de dades, codi "
					+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("Message", "La icona s'ha actualitzat correctament");
		response.put("icona", iconaUpdate);

		System.out.println("La icona s'ha actualitzat correctament, codi " + HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	/**
	 * ELIMINAR icona
	 * @param id icona
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@DeleteMapping("/icones/icona/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			iconaService.delete(id);
		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'eliminar la icona de la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'eliminar la icona de la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "La icona s'ha eliminat correctament");
		System.out.println("La icona s'ha eliminat correctament, codi " + HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
}
