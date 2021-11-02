package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IUsuariDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;

/**
 * Classe per implementar metodes de service
 * @author Gemma Rica
 *
 */
@Service
public class UsuariServiceImpl implements IUsuariService{

	@Autowired
	private IUsuariDao usuariDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuari> findAll() {
		return (List<Usuari>) usuariDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuari findById(Long id) {	
		return usuariDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuari findByUsername(String username) {	
		return usuariDao.findByUsername(username);
	}


	@Override
	@Transactional
	public Usuari save(Usuari usuari) {
		return usuariDao.save(usuari);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Role> findAllRoles() {
		return usuariDao.findAllRoles();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuari> findByVoice(String voice) {
		return usuariDao.findByVoice();
	}
	


}
