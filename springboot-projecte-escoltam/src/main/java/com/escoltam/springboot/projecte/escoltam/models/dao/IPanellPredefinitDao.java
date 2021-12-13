package com.escoltam.springboot.projecte.escoltam.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;


/**
 * Classe per accedir, fer consulta, etc... a la BD de la taula PANELLPREDEFINIT.
 * CrudRepository --> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
 * @author Gemma Rica
 *
 */
public interface IPanellPredefinitDao extends CrudRepository<PanellPredefinit, Long>{

	/**
	 * CERCAR panell predefinit per id
	 * @param id
	 * @return panell predefinit
	 */
	@Query("select p from PanellPredefinit p where p.id=?1")
	public PanellPredefinit findPanellPredefinitById(Long id);

}
