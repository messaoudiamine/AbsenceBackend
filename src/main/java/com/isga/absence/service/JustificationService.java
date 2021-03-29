package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Justification;
import com.isga.absence.repo.JustificationRepo;

@Service
public class JustificationService {
	
	@Autowired
	private JustificationRepo justificationRepo; 
	
	/**
	 * save & update
	 * @param just
	 * @return
	 */
	public Justification save(Justification just) {
		return justificationRepo.save(just);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Justification> getAll(){
		
		return justificationRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Justification getById(Integer id) {
		return justificationRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Objet
	 * @param just
	 */
	public void delete(Justification just) {
		justificationRepo.delete(just);
	}

}
