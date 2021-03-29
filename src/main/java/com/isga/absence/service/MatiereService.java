package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Matiere;
import com.isga.absence.repo.MatiereRepo;

@Service
public class MatiereService {

	

	@Autowired
	private MatiereRepo matiereRepo; 
	
	/**
	 * save & update
	 * @param mat
	 * @return
	 */
	public Matiere save(Matiere mat) {
		return matiereRepo.save(mat);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Matiere> getAll(){
		
		return matiereRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Matiere getById(Integer id) {
		return matiereRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By id
	 * @param mat
	 */
	public void delete(Integer id) {
		matiereRepo.deleteById(id);
	}
	/**
	 * Find By intitule
	 * @param intitule
	 */
	public Matiere findByName(String intitule) {
		return matiereRepo.findByintitule(intitule);
	}
}
