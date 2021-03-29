package com.isga.absence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Seance;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Integer>{
	
	public List<Seance> findByProfesseurId(Integer id_prof);

}
