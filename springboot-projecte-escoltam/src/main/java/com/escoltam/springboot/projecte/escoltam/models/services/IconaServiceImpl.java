package com.escoltam.springboot.projecte.escoltam.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IIconaDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;

@Service
public class IconaServiceImpl implements IIconaService{

	@Autowired
	private IIconaDao iconaDao;
	
	@Override
	@Transactional(readOnly=true)
	public Icona findIconaById(Long id) {
		return iconaDao.findIconaById(id);
	}



}
