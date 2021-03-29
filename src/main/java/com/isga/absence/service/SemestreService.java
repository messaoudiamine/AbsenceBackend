package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Semestre;
import com.isga.absence.repo.SemestreRepo;

@Service
public class SemestreService {
	
	@Autowired
	private SemestreRepo semestereRepo; 
	
	/**
	 * save & update
	 * @param sems
	 * @return
	 */
	public Semestre save(Semestre sems) {
		return semestereRepo.save(sems);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Semestre> getAll(){
		
		return semestereRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Semestre getById(Integer id) {
		return semestereRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Objet
	 * @param sems
	 */
	public void delete(Semestre sems) {
		semestereRepo.delete(sems);
	}

}
