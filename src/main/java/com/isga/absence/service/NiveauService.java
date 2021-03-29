package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Niveau;
import com.isga.absence.repo.NiveauRepo;

@Service
public class NiveauService {

	@Autowired
	private NiveauRepo niveauRepo;
	
	/**
	 * save & update
	 * @param niveau
	 * @return
	 */
	public Niveau save(Niveau niveau) {
		return niveauRepo.save(niveau);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Niveau> getAll(){
		
		return niveauRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Niveau getById(Integer id) {
		return niveauRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By id
	 * @param id
	 */
	public void deleteByid(Integer id) {
		niveauRepo.deleteById(id);
	}
	/**
	 * find niveau By name
	 * @param niveau
	 */
	public Niveau findNiveauByName(String name) {
		return niveauRepo.findByIntitule(name);
	}
}
