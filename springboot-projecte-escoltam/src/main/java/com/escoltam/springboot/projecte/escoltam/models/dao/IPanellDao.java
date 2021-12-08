package com.escoltam.springboot.projecte.escoltam.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;

/**
 * Classe per accedir, fer consulta, etc... a la BD de la taula PANELL.
 * CrudRepository --> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
 * @author Gemma Rica
 *
 */

public interface IPanellDao extends CrudRepository<Panell, Long>{

	/**
	 * Llistar tots els PANELLS de l'USUARI.
	 * @param username de l'usuari
	 * @return llistat de panells que té l'usuari
	 */
	@Query("select p from Panell p where p.usuari = (select u.id from Usuari u where u.username=?1)")
	public List<Panell> findAllPanellsByUsername (String username);
	
	/**
	 * Buscar un panell per username i id panell
	 * @param id panell
	 * @param username usuari
	 * @return panell
	 */
	@Query("select p from Panell p where p.id=?1 and p.usuari = (select u.id from Usuari u where u.username=?2)")
	public Panell findPanellByUsername(Long id, String username);
	
	/**
	 * Buscar panell per la seva ID
	 * @param id de panell
	 * @return panell
	 */
	@Query("select p from Panell p where p.id=?1")
	public Panell findPanellById(Long id);
	
	/**
	 * Buscar panell favorit de l'usuari (FILTRE)
	 * @param username
	 * @return panell favorit
	 */
	@Query("select p from Panell p where p.favorit=true and p.usuari = (select u.id from Usuari u where u.username=?1)")
	public Panell findPanellFavByUsername(String username);
}
