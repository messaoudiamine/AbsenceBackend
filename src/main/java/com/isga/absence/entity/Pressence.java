package com.isga.absence.entity;

import org.springframework.web.multipart.MultipartFile;

public class Pressence {
	
    private Integer id;
	private String matiere;
	private String file;
	private String beghour;
	private String endhour;
	private String niveau;
	private Integer idProf;
    
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getBeghour() {
		return beghour;
	}
	public void setBeghour(String beghour) {
		this.beghour = beghour;
	}
	public String getEndhour() {
		return endhour;
	}
	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public Integer getIdProf() {
		return idProf;
	}
	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}
	
	
}
