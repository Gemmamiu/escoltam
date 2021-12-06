package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;



public interface IIconaService {
	
	public Icona findIconaById(Long id);

	public List<Icona> findIconesFav(Boolean fav, String username);
}
