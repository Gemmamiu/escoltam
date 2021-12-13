package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.HashMap;
import java.util.List;
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

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.services.IPanellService;
import com.escoltam.springboot.projecte.escoltam.models.services.IUsuariService;

/**
 * Controller REST: URL per conectar, enviar dades i peticions a l'app
 * Controller de PANELL 
 * @author Gemma Rica
 *
 */
@RestController
@RequestMapping("/app")
public class PanellRestController {
	
	@Autowired
	private IPanellService panellService;
	
	@Autowired
	private IUsuariService usuariService;
	

	/**
	 * LLISTA de tots els panells de l'usuari
	 * @param username
	 * @return llistat de panells
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panells/{username}")
	public ResponseEntity<?> index(@PathVariable String username){
		List<Panell> panells = null;
		Map<String, Object> response = new HashMap<>();
		
		// Control errors al realitzar la crida en la base de dades
		try {
			panells = panellService.findAllPanells(username);
		} catch (DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "
					+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Cerca de panells de l'usuari " + username + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<List<Panell>>(panells, HttpStatus.OK);
	}
	
	/**
	 * CERCAR panell per id i username
	 * @param username
	 * @param id
	 * @return panell
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panells/{username}/{id}")
	public ResponseEntity<?> show(@PathVariable String username, @PathVariable Long id) {
		Panell panell = null;
		Map<String, Object> response = new HashMap<>();
		// Control errors al realitzar la crida en la base de dades
		try {
			panell = panellService.findPanellByUsername(id, username);
		} catch (DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "
					+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Control errors per si no existeix usuari que es cerca
		if (panell == null) {
			response.put("Message", "Panell amb Id " + id + " no existeix!");
			System.out.println("El panell no existeix, codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		System.out.println("Cerca del panell de l'usuari " + username + " i id panell " + id + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<Panell>(panell, HttpStatus.OK);
	}
	
	/**
	 * AFEGIR PANELL
	 * @param username
	 * @param panell RequestBody
	 * @return panell afegit i missatge
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/panells/{username}")
	public ResponseEntity<?> create(@PathVariable String username, @RequestBody Panell panell){
		
		Map<String, Object> response = new HashMap<>();
		Panell panellNew = null;
		Usuari usuari = null;
		
		try {
			
			usuari= usuariService.findByUsername(username);
			
			panellNew = panellService.save(panell);
			panellNew.setUsuari(usuari);
			panellNew = panellService.save(panell);
			
		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de afegir panell en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de afegir panell en la base de dades, codi: " + HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Message", "El panell s'ha creat correctament");
		response.put("panell", panellNew);
		
		System.out.println("El panell s'ha creat correctament, codi: " + HttpStatus.CREATED);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * EDITAR panell
	 * @param username del usuari
	 * @param id del que hem d'editar
	 * @param panell RequestBody
	 * @return panell editat i missatge
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PutMapping("/panells/{username}/{id}")
	public ResponseEntity<?> update(@PathVariable String username, @PathVariable Long id, @RequestBody Panell panell){
		
		Map<String, Object> response = new HashMap<>();
		Panell panellActual = panellService.findPanellById(id);
		Panell panellUpdate = null;
		Usuari usuari = usuariService.findByUsername(username);
		
		// Control errors per si no existeix panell que es cerca
		if (panellActual == null) {
			response.put("Message",
					"Error, el panell no s'ha pogut editar, panell amb id " + id + " no existeix en la base de dades!");
			System.out.println("Error, el panell no s'ha pogut editar, panell amb " + id
					+ " no existeix en la base de dades! " + "Codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		//Control errors al realitzar la crida en la base de dades
		try {
			
			panellActual.setNom(panell.getNom());
			panellActual.setPosicio(panell.getPosicio());
			panellActual.setFavorit(panell.isFavorit());
			panellActual.setUsuari(usuari);
			panellUpdate = panellService.save(panellActual);
			
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'actualitzar el panell en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'actualitzar el panell en la base de dades, codi " + HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "El panell s'ha actualitzat correctament");
		response.put("panell", panellUpdate);
		
		System.out.println("El panell s'ha actualitzat correctament, codi " + HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/**
	 * ELIMINAR panell
	 * @param id
	 * @return missatge de panell eliminat
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@DeleteMapping("/panells/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			panellService.delete(id);
		} catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'eliminar el panell de la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'eliminar el panell de la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "El panell s'ha eliminat correctament");
		System.out.println("El panell s'ha eliminat correctament, codi " + HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * CERCA de panell FAVORIT
	 * @param username
	 * @return panell favorit
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/panells/fav/{username}")
	public ResponseEntity<?> showPanellFav (@PathVariable String username) {
		
		Map<String, Object> response = new HashMap<>();
		Panell panellFav = null;
		
		//Control errors al realitzar la crida en la base de dades
		try {
			panellFav =  panellService.findPanellFavByUsername(username);		
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		System.out.println("Cerca de panell favorit de " + username + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<Panell>(panellFav, HttpStatus.OK);
	}
	
}
