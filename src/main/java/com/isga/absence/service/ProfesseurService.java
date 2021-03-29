package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Professeur;
import com.isga.absence.repo.ProfesseurRepo;

@Service
public class ProfesseurService {

	
	@Autowired
	private ProfesseurRepo professeurRepo; 
	
	/**
	 * save & update
	 * @param prof
	 * @return
	 */
	public Professeur save(Professeur prof) {
		return professeurRepo.save(prof);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Professeur> getAll(){
		
		return professeurRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Professeur getById(Integer id) {
		return professeurRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By id
	 * @param id
	 */
	public void delete(Integer id) {
		professeurRepo.deleteById(id);
	}
	/**
	 * @param login and password
	 */
//	public Professeur AuthProfesseur(String login, String password) {
//		return professeurRepo.findProfesseurByusernameAndpassword(login, password);
//	}
}
