package com.escoltam.springboot.projecte.escoltam.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;

public interface IPanellDao extends CrudRepository<Panell, Long>{

	@Query("select p from Panell p where p.usuari = (select u.id from Usuari u where u.username=?1)")
	public List<Panell> findAllPanellsByUsername (String username);
	
	@Query("select p from Panell p where p.id=?1 and p.usuari = (select u.id from Usuari u where u.username=?2)")
	public Panell findPanellByUsername(Long id, String username);
	
	@Query("select p from Panell p where p.id=?1")
	public Panell findPanellById(Long id);
	
	@Query("select p from Panell p where p.favorit=true and p.usuari = (select u.id from Usuari u where u.username=?1)")
	public Panell findPanellFavByUsername(String username);
}
