package com.escoltam.springboot.projecte.escoltam.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;

public interface IPanellPredefinitDao extends CrudRepository<PanellPredefinit, Long>{

	@Query("select p from PanellPredefinit p where p.id=?1")
	public PanellPredefinit findPanellPredefinitById(Long id);
	
	//@Transactional
	@Modifying
	@Query("delete from Usuari u where u.username=?1 and u.panellPredefinits in (select p from PanellPredefinit p where p.id=?2)")
	public void deletePanellPredefinit(String username, Long id);
}
