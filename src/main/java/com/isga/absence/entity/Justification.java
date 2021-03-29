package com.isga.absence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Justification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	
	@NotNull
	private String motif;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Justification(String motif) {
		super();
		this.motif = motif;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Justification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
