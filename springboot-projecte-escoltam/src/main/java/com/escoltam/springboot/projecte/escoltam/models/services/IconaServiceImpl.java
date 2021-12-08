package com.escoltam.springboot.projecte.escoltam.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IIconaDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;

/**
 * Classe per implementar metodes de service
 * @author Gemma Rica
 *
 */
@Service
public class IconaServiceImpl implements IIconaService{

	@Autowired
	private IIconaDao iconaDao;
	
	@Override
	@Transactional(readOnly=true)
	public Icona findIconaById(Long id) {
		return iconaDao.findIconaById(id);
	}

	@Override
	@Transactional
	public Icona save(Icona icona) {
		return iconaDao.save(icona);
	}

	@Override
	public void delete(Long id) {
		iconaDao.deleteById(id);
		
	}





}
