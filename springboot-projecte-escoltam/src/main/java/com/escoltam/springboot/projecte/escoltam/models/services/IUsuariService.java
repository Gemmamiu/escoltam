package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;

/**
 * On li donarem els mètodes del CRUD
 * @author Gemma Rica
 *
 */
public interface IUsuariService {

	/**
	 * LLISTAR usuaris
	 * @return llista d'usuaris (List)
	 */
	public List<Usuari> findAll();
	
	/**
	 * CERCAR usuaris per id
	 * @param id
	 * @return Usuari
	 */
	public Usuari findById(Long id);
	
}
