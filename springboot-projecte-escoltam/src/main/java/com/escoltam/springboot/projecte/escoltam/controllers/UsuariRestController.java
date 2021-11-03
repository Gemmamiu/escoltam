package com.escoltam.springboot.projecte.escoltam.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari.Voice;
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
	 * LLISTAR (paginació) usuaris
	 * @return Pagina amb Llista d'usuaris
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris/page/{page}")
	public Page<Usuari> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 10);
		return usuariService.findAll(pageable); //endpoint
	}
	
	
	/**
	 * CERCAR usuaris
	 * @param username username de l'usuari
	 * @return usuariService l'usuari amb el username passat per parametre
	 * @exception DataAccessException error al realitzar la cria en la bd
	 */
	@Secured("ROLE_ADMIN")
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
	 * CERCAR tots els rols
	 * @return Llistat de rols que hi ha a l'aplicació
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris/roles")
	public List<Role> listRoles(){
		return usuariService.findAllRoles();
	}
	
	/**
	 * CERCA amb FILTRE de veu
	 * @param voice veu que es desitja filtrar
	 * @return listUsuaris llistat d'usuaris amb una veu pasada com a parametre
	 * @exception DataAccessException error al realitzar la cria en la bd
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris/voice/{voice}")
	public ResponseEntity<?> searchVoice(@PathVariable Voice voice) { 
		
		List<Usuari> listUsuaris = null;
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			listUsuaris =  usuariService.listAll(voice);		
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (listUsuaris == null) {
			response.put("Message", "La veu " + voice + " no existeix!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Usuari>>(listUsuaris, HttpStatus.OK);
	}
	
	/**
	 * CERCA amb FILTRE segons el Rol d'usuari
	 * @param role_name rol que es desitja filtrar
	 * @return listUsuaris llistat d'usuaris amb el rol passat com a parametre
	 * @exception DataAccessException error al realitzar la cria en la bd
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris/roles/{role_name}")
	public ResponseEntity<?> searchByRole(@PathVariable String role_name) { 
		
		List<Usuari> listUsuaris = null;
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			listUsuaris =  usuariService.listAll(role_name);		
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (listUsuaris == null) {
			response.put("Message", "El rol " + role_name + " no existeix!");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Usuari>>(listUsuaris, HttpStatus.OK);
	}
}
