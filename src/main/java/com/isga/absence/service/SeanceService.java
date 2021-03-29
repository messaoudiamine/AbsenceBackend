package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Seance;
import com.isga.absence.repo.SeanceRepo;

@Service
public class SeanceService {

	@Autowired
	private SeanceRepo seanceRepo; 
	
	/**
	 * save & update
	 * @param seance
	 * @return
	 */
	public Seance save(Seance seance) {
		return seanceRepo.save(seance);		
	}
	/**
	 * save 
	 * @param seance
	 * @return void
	 */
	public String saveImg(String image) {
			return "test "+ image;
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Seance> getAll(){
		
		return seanceRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Seance getById(Integer id) {
		return seanceRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Objet
	 * @param id
	 */
	public void delete(Integer id) {
		seanceRepo.deleteById(id);
	}
	/**
	 * Find Seance by id prof
	 * @param id
	 * @return
	 */
	public List<Seance> getSeanceByIdProf(Integer id_prof) {
		return seanceRepo.findByProfesseurId(id_prof);
	}
	
}
