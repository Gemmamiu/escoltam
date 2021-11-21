package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IUsuariDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Role;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari;
import com.escoltam.springboot.projecte.escoltam.models.entity.Usuari.Voice;

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
	public Page<Usuari> findAll(Pageable pageable) {
		return usuariDao.findAll(pageable);
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


	//Sobreescriure el metode listAll per llistar els usuaris segons veu
	@Override
	@Transactional(readOnly=true)
	public List<Usuari> listAll(Voice voice) {
		
		if (voice != null) {
			if (usuariDao.findByVoice(voice).isEmpty()) {
				return null;
			} else {
				return usuariDao.findByVoice(voice);
			}

		}

		return usuariDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuari> listAll(String role_name) {
		if (role_name != null){
			if(usuariDao.findByRole(role_name).isEmpty()) {
				return null;
			}else {
				return usuariDao.findByRole(role_name);
			}
			
		}
		return usuariDao.findAll();
	}

	@Override
	@Transactional
	public void delete(String username) {
		usuariDao.deleteByUsername(username);
		
	}



}
