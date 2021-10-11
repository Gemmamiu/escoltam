package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IUsuariDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;

//Classe per implementar metodes de service
@Service
public class UsuariServiceImpl implements IUsuariService{

	@Autowired
	private IUsuariDao usuariDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuari> findAll() {
		
		return (List<Usuari>) usuariDao.findAll();
	}

}
