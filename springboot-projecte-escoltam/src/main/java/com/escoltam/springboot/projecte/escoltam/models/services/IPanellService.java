package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;

/**
 * On li donarem els mètodes del CRUD
 * @author Gemma Rica
 *
 */
public interface IPanellService {
	
	/**
	 * LLISTAR panells per usuari
	 * @param username
	 * @return llistat de panells
	 */
	public List<Panell> findAllPanells(String username);
	
	/**
	 * CERCAR panell per id i per username
	 * @param id
	 * @param username
	 * @return panell
	 */
	public Panell findPanellByUsername(Long id, String username);
	
	/**
	 * CERCAR panell per id
	 * @param id
	 * @return panell
	 */
	public Panell findPanellById(Long id);
	
	/**
	 * GUARDAR panell
	 * @param panell
	 * @return panell guardat
	 */
	public Panell save(Panell panell);
	
	/**
	 * ELIMINAR panell
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * FILTRE panell preferit per usuari
	 * @param username
	 * @return panell preferit
	 */
	public Panell findPanellFavByUsername(String username);
	
	public void deletePanellsByUsername(String username);
}

