package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Niveau;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau, Integer>{
	public Niveau findByIntitule(String name);

}
