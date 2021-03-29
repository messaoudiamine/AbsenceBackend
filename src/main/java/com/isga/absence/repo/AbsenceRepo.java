package com.isga.absence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Absence;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Integer>{
	
//	@Query("SELECT abs FROM absence abs inner join etudiant etd WHERE abs.etudiant_id = etd.id and etd.niveau_id = ?1")
//	public List<Absence> listAbsences(Integer id);

}
