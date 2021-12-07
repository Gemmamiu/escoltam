package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import com.escoltam.springboot.projecte.escoltam.models.entity.Panell;

public interface IPanellService {
	
	public List<Panell> findAllPanells(String username);
	
	public Panell findPanellByUsername(Long id, String username);
	
	public Panell findPanellById(Long id);
	
	public Panell save(Panell panell);
	
	public void delete(Long id);
	
	public List<Panell> findAll();
	
	public Panell findPanellFavByUsername(String username);
}

