package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Matiere;

@Repository
public interface MatiereRepo extends JpaRepository<Matiere, Integer>{
	
	public  Matiere findByintitule(String intitule);

}
