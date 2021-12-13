package com.escoltam.springboot.projecte.escoltam.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escoltam.springboot.projecte.escoltam.models.dao.IPanellPredefinitDao;
import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;

/**
 * Classe per implementar metodes de service
 * @author Gemma Rica
 *
 */
@Service
public class PanellPredefinitServiceImpl implements IPanellPredefinitService{

	@Autowired
	private IPanellPredefinitDao panellPredefinitDao;

	@Override
	@Transactional(readOnly=true)
	public PanellPredefinit findPanellPredefinitById(Long id) {
		return panellPredefinitDao.findPanellPredefinitById(id);
	}

	
}
