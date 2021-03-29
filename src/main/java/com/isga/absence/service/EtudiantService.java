package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.isga.absence.entity.Etudiant;
import com.isga.absence.repo.EtudiantRepo;

@Service
public class EtudiantService {
	
	@Autowired
	private EtudiantRepo etudiantRepo; 
	
	/**
	 * save & update
	 * @param etudiant
	 * @return
	 */
	public Etudiant save(Etudiant etudiant) {
		return etudiantRepo.save(etudiant);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Etudiant> getAll(){
		
		return etudiantRepo.findAll();
	}
	
	/**
	 * Find a etudiant by id
	 * @param id
	 * @return
	 */
	public Etudiant getById(Integer id) {
		return etudiantRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Id
	 * @param etudiant
	 */
	public void deleteByid(Integer id) {
		etudiantRepo.deleteById(id);
	}
	/**
	 * List etudiants By Id niveau
	 * @param etudiant
	 */
	@Query("SELECT etd FROM etudiant etd WHERE etd.niveau_id =?1")
	public List<Etudiant> getLisEtudtByNiveau(Integer id) {
		return etudiantRepo.findEtudiantByNiveau_id(id);
	}
	
}
