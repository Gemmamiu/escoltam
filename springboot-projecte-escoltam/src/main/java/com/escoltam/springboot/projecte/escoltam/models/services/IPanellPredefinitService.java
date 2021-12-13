package com.escoltam.springboot.projecte.escoltam.models.services;

import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;

/**
 * On li donarem els mètodes del CRUD
 * @author Gemma Rica
 *
 */
public interface IPanellPredefinitService {
	
	/**
	 * CERCAR panell predefinit per id
	 * @param id
	 * @return panell predefinit
	 */
	public PanellPredefinit findPanellPredefinitById (Long id);
	
}
