package com.isga.absence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nom_prof;
	private String prenom_prof;
	private String tel_prof;
	private String mail_prof;
//	private String username;
//	private String password;
	
    @OneToMany(mappedBy = "professeur")
	 private List<Matiere> matieres = new ArrayList<>();
    
    @OneToMany(mappedBy = "professeur")
     private List<Seance> seance = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom_prof() {
		return nom_prof;
	}
	public void setNom_prof(String nom_prof) {
		this.nom_prof = nom_prof;
	}
	public String getPrenom_prof() {
		return prenom_prof;
	}
	public void setPrenom_prof(String prenom_prof) {
		this.prenom_prof = prenom_prof;
	}
	public String getTel_prof() {
		return tel_prof;
	}
	public void setTel_prof(String tel_prof) {
		this.tel_prof = tel_prof;
	}
	public String getMail_prof() {
		return mail_prof;
	}
	public void setMail_prof(String mail_prof) {
		this.mail_prof = mail_prof;
	}
	

}
