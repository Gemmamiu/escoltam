package com.escoltam.springboot.projecte.escoltam.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;


public interface IIconaDao extends CrudRepository<Icona, Long>{
	
	//@Query("select i from Icona i join i.panell p where p.id=?1 and p.usuari = (select u.id from Usuari u where u.username=?2)")
	//@Query("select i from Icona i where i.panell = (select p.id from Panell p where p.id=?1 and p.usuari = (select u.id from Usuari u where u.username=?2))")
	@Query("select i from Icona i where i.id=?1")
	public Icona findIconaById (Long id);

}
