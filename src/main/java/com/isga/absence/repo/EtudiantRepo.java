package com.isga.absence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
	
	public List<Etudiant> findEtudiantByNiveau_id(Integer niveau_id);

}
