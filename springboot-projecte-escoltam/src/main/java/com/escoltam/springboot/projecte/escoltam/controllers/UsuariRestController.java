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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	// PANTALLA ADMIN amb les funcions
	
	/**
	 * LLISTAR usuaris
	 * @return Llista d'usuaris
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris")
	public List<Usuari> index(){
		System.out.println("Mostra llistat d'usuaris");
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
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (usuari == null) {
			response.put("Message", "L'usuari amb " + username + " no existeix!");
			System.out.println("L'usuari no existeix, codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Cerca de l'usuari " + username + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<Usuari>(usuari, HttpStatus.OK);
	}
	
	/**
	 * CERCAR tots els rols
	 * @return Llistat de rols que hi ha a l'aplicació
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuaris/roles")
	public List<Role> listRoles(){
		System.out.println("Mostra llistat de rols");
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
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (listUsuaris == null) {
			response.put("Message", "La veu " + voice + " no existeix!");
			System.out.println("La veu no existeix, codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		System.out.println("Cerca de veu " + voice + " amb codi " + HttpStatus.OK);
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
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (listUsuaris == null) {
			response.put("Message", "El rol " + role_name + " no existeix!");
			System.out.println("El rol no existeix, coid " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		System.out.println("Cerca de rol " + role_name + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<List<Usuari>>(listUsuaris, HttpStatus.OK);
	}
	
	//PERFIL USUARI I ADMIN
	
	/**
	 * PERFIL USUARI
	 * @param username email de l'usuari
	 * @return el perfil de l'usuari
	 */
	@GetMapping("/usuaris/profile/{username}")
	public ResponseEntity<?> showProfile(@PathVariable String username) { 
		
		Usuari usuari = null;
		Map<String, Object> response = new HashMap<>();
		
		//Control errors al realitzar la crida en la base de dades
		try {
			
			usuari =  usuariService.findByUsername(username);
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora de realitzar la consula en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//Control errors per si no existeix usuari que es cerca
		if (usuari == null) {
			response.put("Message", "L'usuari amb " + username + " no existeix!");
			System.out.println("L'usuari no existeix, codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Cerca d'usuari " + username + " amb codi " + HttpStatus.OK);
		return new ResponseEntity<Usuari>(usuari, HttpStatus.OK);
	}
	
	/**
	 * ESBORRAR usuari
	 * @param username email de l'usuari
	 * @return Http status OK -> s'ha esborrat correctament
	 */
	@DeleteMapping("/usuaris/profile/{username}")
	public ResponseEntity<?> delete(@PathVariable String username) {
	
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			usuariService.delete(username);
			
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'eliminar l'usuari de la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora de realitzar la consula en la base de dades amb codi "+ HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "L'usuari s'ha eliminat correctament");
		System.out.println("L'usuari s'ha eliminat correctament, codi " + HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * EDITAR perfil usuari
	 * @param usuari objecte usuari a editar
	 * @param username email de l'usuari a editar
	 * @return usuari actualitzat
	 */
	@PutMapping("/usuaris/profile/{username}")
	public ResponseEntity<?> update(@RequestBody Usuari usuari, @PathVariable String username) {
		
		Map<String, Object> response = new HashMap<>();

		Usuari usuariActual = usuariService.findByUsername(username);
		
		Usuari usuariUpdate = null;
		
		//Control errors per si no existeix usuari que es cerca
		if (usuariActual == null) {
			response.put("Message", "Error, l'usuari no s'ha pogut editar, l'usuari " + username + " no existeix en la base de dades!");
			System.out.println("Error, l'usuari no s'ha pogut editar, l'usuari " + username + " no existeix en la base de dades! "
					+ "Codi " + HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		//Control errors al realitzar la crida en la base de dades
		try {
					
			usuariActual.setVoice(usuari.getVoice());
			usuariActual.setPassword(passwordEncoder.encode(usuari.getPassword()));
			
			usuariUpdate = usuariService.save(usuariActual);
			
		}catch(DataAccessException e) {
			response.put("Message", "ERROR a l'hora d'actualitzar el client en la base de dades");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			System.out.println("ERROR a l'hora d'actualitzar el client en la base de dades, codi " + HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Message", "L'usuari s'ha actualitzat correctament");
		response.put("usuari", usuariUpdate);
		
		System.out.println("L'usuari s'ha actualitzat correctament, codi " + HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
}
