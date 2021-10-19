package com.escoltam.springboot.projecte.escoltam.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;


/**
 * Classe per accedir, fer consulta, etc... a la BD.
 * CrudRepository --> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
 * @author Gemma Rica
 *
 */
public interface IUsuariDao extends CrudRepository<Usuari, Long>{
	
	/**
	 * Buscar per email (username)
	 * @param username
	 * @return usuari
	 */
	public Usuari findByUsername (String username);
	
	//prova, funciona igual que l'anterior
	@Query("select u from Usuari u where u.username=?1")
	public Usuari findByUsername2 (String username);
	
	/**
	 * LListar roles
	 * @return llista de roles
	 */
	@Query("from Role")
	public List<Role> findAllRoles();
	

}
