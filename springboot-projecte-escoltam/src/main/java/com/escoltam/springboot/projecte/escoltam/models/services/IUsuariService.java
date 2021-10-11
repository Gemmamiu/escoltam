package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;

//On li donarem els mètodes del CRUD
public interface IUsuariService {

	public List<Usuari> findAll();
}
