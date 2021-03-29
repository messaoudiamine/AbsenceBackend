package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.Absence;
import com.isga.absence.repo.AbsenceRepo;

@Service
public class AbsenceService {
	
	@Autowired
	private AbsenceRepo absenceRepo;
	
	/**
	 * save & update
	 * @param absence
	 * @return
	 */
	public Absence save(Absence absence) {
		return absenceRepo.save(absence);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<Absence> getAll(){
		
		return absenceRepo.findAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Absence getById(Integer id) {
		return absenceRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Objet
	 * @param absence
	 */
	public void delete(Absence absence) {
		absenceRepo.delete(absence);
	}
	/**
	 * List etudiants By Id niveau
	 * @param etudiant
	 */
//	@Query("SELECT abs FROM absence abs INNER JOIN etudiant etd WHERE abs.etudiant_id = etd.id and etd.niveau_id = ?1")
//	public List<Absence> getListAbsenceByNiveau(Integer id) {
//		return absenceRepo.listAbsences(id);
//	}

}
