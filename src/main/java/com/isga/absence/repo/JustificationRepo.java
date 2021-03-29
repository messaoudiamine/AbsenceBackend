package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Justification;

@Repository
public interface JustificationRepo  extends JpaRepository<Justification, Integer>{

}
