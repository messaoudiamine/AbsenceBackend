package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.AnneeScolaire;
import com.isga.absence.repo.AnneeScolaireRepo;

@Service
public class AnneeScolaireService {

	@Autowired
	private AnneeScolaireRepo anneeRepo;
	
	/**
	 * save & update
	 * @param sems
	 * @return
	 */
	public AnneeScolaire save(AnneeScolaire anneSc) {
		return anneeRepo.save(anneSc);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<AnneeScolaire> getAll(){
		
		return anneeRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public AnneeScolaire getById(Integer id) {
		return anneeRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Id
	 * @param sems
	 */
	public void delete(Integer id) {
		anneeRepo.deleteById(id);
	}
}
