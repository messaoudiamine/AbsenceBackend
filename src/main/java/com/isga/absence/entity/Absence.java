package com.isga.absence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
public class Absence {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String heure_debut;
	
	@NotNull
	private String heure_Fin;
	
	private String justif;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_absence")
	private Date date_absence;
	
	private Boolean etat;
	
//	public Justification getJustification() {
//		return justification;
//	}
//
//	public void setJustification(Justification justification) {
//		this.justification = justification;
//	}

	@ManyToOne
	private Seance seance;
	
//	@ManyToOne
//	private Justification justification;
	
	@ManyToOne
	private Etudiant etudiant;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(String heure_debut) {
		this.heure_debut = heure_debut;
	}

	public String getHeure_Fin() {
		return heure_Fin;
	}

	public void setHeure_Fin(String heure_Fin) {
		this.heure_Fin = heure_Fin;
	}

	public Date getDate_absence() {
		return date_absence;
	}

	public void setDate_absence(Date date_absence) {
		this.date_absence = date_absence;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getJustif() {
		return justif;
	}

	public void setJustif(String justif) {
		this.justif = justif;
	}

	public Absence(@NotNull String heure_debut, @NotNull String heure_Fin, Date date_absence, Boolean etat,
			Seance seance, Etudiant etudiant,String justif) {
		super();
		this.heure_debut = heure_debut;
		this.heure_Fin = heure_Fin;
		this.date_absence = date_absence;
		this.etat = etat;
		this.seance = seance;
		this.etudiant = etudiant;
		this.justif = justif;
	}
	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
}
