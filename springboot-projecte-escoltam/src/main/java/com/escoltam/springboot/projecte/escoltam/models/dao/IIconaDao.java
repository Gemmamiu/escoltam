package com.escoltam.springboot.projecte.escoltam.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;

/**
 * Classe per accedir, fer consulta, etc... a la BD de la taula ICONA.
 * CrudRepository --> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
 * @author Gemma Rica
 *
 */

public interface IIconaDao extends CrudRepository<Icona, Long>{

	/**
	 * Buscar icona per id icona
	 * @param id
	 * @return icona amb el id passat per parametre
	 */
	@Query("select i from Icona i where i.id=?1")
	public Icona findIconaById (Long id);
		

}
