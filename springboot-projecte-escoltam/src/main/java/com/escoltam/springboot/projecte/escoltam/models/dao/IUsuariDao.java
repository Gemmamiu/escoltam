package com.escoltam.springboot.projecte.escoltam.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;


//Classe per accedir, fer consulta, etc... a la BD
//CrudRepository -> implementa mètodes de consulta (Taula que fem la cerca, tipus de dada)
public interface IUsuariDao extends CrudRepository<Usuari, Long>{
	
	public Usuari findByUsername (String username);
	
	@Query("select u from Usuari u where u.username=?1")
	public Usuari findByUsername2 (String username);

}
