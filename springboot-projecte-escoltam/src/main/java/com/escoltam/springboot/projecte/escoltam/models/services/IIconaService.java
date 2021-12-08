package com.escoltam.springboot.projecte.escoltam.models.services;


import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;


/**
 * On li donarem els mètodes del CRUD
 * @author Gemma Rica
 *
 */
public interface IIconaService {
	
	/**
	 * Cercar icona per id
	 * @param id
	 * @return icona
	 */
	public Icona findIconaById(Long id);
	
	/**
	 * Guardar icona
	 * @param icona
	 * @return icona guardada
	 */
	public Icona save(Icona icona);
	
	/**
	 * Eliminar icona
	 * @param id
	 */
	public void delete(Long id);
	
	

}
