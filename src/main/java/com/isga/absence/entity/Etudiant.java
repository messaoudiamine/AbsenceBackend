package com.isga.absence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String nom_etud;
	@NotNull
	private String prenom_etud;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
	private String sexe_etud;
	
	@Temporal(TemporalType.DATE)
	private Date date_nais_etud;
	private String lieu_naissance_etud;
	private String cin_etud;
	@NotNull
	private String photo_etud;
	private String telephone_etud;
	private String mail_etud;

	public String getTelephone_etud() {
		return telephone_etud;
	}
	public void setTelephone_etud(String telephone_etud) {
		this.telephone_etud = telephone_etud;
	}
	public String getMail_etud() {
		return mail_etud;
	}
	public void setMail_etud(String mail_etud) {
		this.mail_etud = mail_etud;
	}
	@ManyToOne
	private Niveau niveau;
	
	@OneToMany(mappedBy = "etudiant")
	List<Absence> absences = new ArrayList<>();
	
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public String getNom_etud() {
		return nom_etud;
	}
	public void setNom_etud(String nom_etud) {
		this.nom_etud = nom_etud;
	}
	public String getPrenom_etud() {
		return prenom_etud;
	}
	public void setPrenom_etud(String prenom_etud) {
		this.prenom_etud = prenom_etud;
	}
	public String getSexe_etud() {
		return sexe_etud;
	}
	public void setSexe_etud(String sexe_etud) {
		this.sexe_etud= sexe_etud;
	}
	public Date getDate_nais_etud() {
		return date_nais_etud;
	}
	public void setDate_nais_etud(Date date_nais_etud) {
		this.date_nais_etud = date_nais_etud;
	}
	public String getLieu_naissance_etud() {
		return lieu_naissance_etud;
	}
	public void setLieu_naissance_etud(String lieu_naissance_etud) {
		this.lieu_naissance_etud = lieu_naissance_etud;
	}
	public String getCin_etud() {
		return cin_etud;
	}
	public void setCin_etud(String cin_etud) {
		this.cin_etud = cin_etud;
	}
	public String getPhoto_etud() {
		return photo_etud;
	}
	public void setPhoto_etud(String photo_etud) {
		this.photo_etud = photo_etud;
	}

}
