package com.isga.absence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Niveau {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String intitule;
	
	@OneToMany(mappedBy = "niveau")
	List<Etudiant> etudiants = new ArrayList<>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "matiere_niveau", 
        joinColumns = { @JoinColumn(name = "niveau_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "matiere_id") }
    )
	List<Matiere> matieres = new ArrayList<>();

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	
	

}
