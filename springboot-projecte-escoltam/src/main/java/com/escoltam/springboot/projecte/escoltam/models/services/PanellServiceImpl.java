package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IPanellDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;

/**
 * Classe per implementar metodes de service
 * @author Gemma Rica
 *
 */
@Service
public class PanellServiceImpl implements IPanellService{

	@Autowired
	private IPanellDao panellDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Panell> findAllPanells(String username) {
		return (List<Panell>) panellDao.findAllPanellsByUsername(username);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Panell findPanellByUsername(Long id, String username) {
		return panellDao.findPanellByUsername(id, username);
	}

	@Override
	@Transactional
	public Panell save(Panell panell) {
		return panellDao.save(panell);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		panellDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Panell findPanellById(Long id) {
		return panellDao.findPanellById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Panell findPanellFavByUsername(String username) {
		return panellDao.findPanellFavByUsername(username);
	}


}
