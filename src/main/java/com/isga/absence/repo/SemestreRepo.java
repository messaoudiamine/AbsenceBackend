package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Semestre;

@Repository
public interface SemestreRepo extends JpaRepository<Semestre, Integer>{

}
