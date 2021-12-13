package com.escoltam.springboot.projecte.escoltam.models.services;

import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;

public interface IPanellPredefinitService {
	
	public PanellPredefinit findPanellPredefinitById (Long id);
	
	public void deletePanellPredefinit(String username, Long id);

}
