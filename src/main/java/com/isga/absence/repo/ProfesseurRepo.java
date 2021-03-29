package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isga.absence.entity.Professeur;

@Repository
public interface ProfesseurRepo extends JpaRepository<Professeur, Integer>{

//    @Query("SELECT prf FROM Professeur prf WHERE prf.username= ?1 and prf.password= ?2")
//	public Professeur findProfesseurByusernameAndpassword(String username, String password);
	

}
