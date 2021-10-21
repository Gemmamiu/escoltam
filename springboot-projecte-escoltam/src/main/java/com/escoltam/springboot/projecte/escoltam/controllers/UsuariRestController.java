package com.escoltam.springboot.projecte.escoltam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
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
	
	/**
	 * LLISTAR usuaris
	 * @return Llista d'usuaris
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
	 * @exception DataAccessException error al realitzar la cria en la bd
	 */
	/*@GetMapping("/usuaris/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) { 
		
		Usuari usuari = null;
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			usuari =  usuariService.findById(id);		
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (usuari == null) {
			response.put("Message", "L'usuari amb " + id + " no existeix!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuari>(usuari, HttpStatus.OK);
	}*/
	
	/**
	 * CERCAR usuaris
	 * @param username username de l'usuari
	 * @return usuariService l'usuari amb el username passat per parametre
	 * @exception DataAccessException error al realitzar la cria en la bd
	 */
	@GetMapping("/usuaris/{username}")
	public ResponseEntity<?> show(@PathVariable String username) { 
		
		Usuari usuari = null;
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			usuari =  usuariService.findByUsername(username);		
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (usuari == null) {
			response.put("Message", "L'usuari amb " + username + " no existeix!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuari>(usuari, HttpStatus.OK);
	}
	
	/**
	 * AFEGIR usuari
	 * @param usuari
	 * @return l'objecte (usuari) creat 
	 */
	@PostMapping("/usuaris")
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
	
	@GetMapping("/usuaris/roles")
	public List<Role> listRoles(){
		return usuariService.findAllRoles();
	}
	
}
