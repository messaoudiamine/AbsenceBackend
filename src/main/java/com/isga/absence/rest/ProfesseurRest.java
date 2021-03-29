package com.isga.absence.rest;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
//import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.isga.absence.entity.Absence;
import com.isga.absence.entity.Etudiant;
import com.isga.absence.entity.Justification;
import com.isga.absence.entity.Matiere;
import com.isga.absence.entity.Niveau;
import com.isga.absence.entity.Pressence;
import com.isga.absence.entity.Professeur;
import com.isga.absence.entity.Seance;
import com.isga.absence.service.AbsenceService;
import com.isga.absence.service.EtudiantService;
import com.isga.absence.service.MatiereService;
import com.isga.absence.service.NiveauService;
import com.isga.absence.service.ProfesseurService;
import com.isga.absence.service.SeanceService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/professeur")
public class ProfesseurRest {


	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private SeanceService seanceService;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private AbsenceService absenceService;
	@Autowired
	private NiveauService niveauService;

	@Value("${image.dir}")
	private String imageDir;
	
	@Value("${python.dir}")
	private String pythonDir;


	/**
	 * save & update
	 * @param prof
	 * @return
	 */
	@PostMapping(value = "/save")
	public Professeur save(@RequestBody Professeur prof) {
		return professeurService.save(prof);		
	}
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Professeur> getAll(){

		return professeurService.getAll();
	}

	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Professeur getById(@PathVariable("id") Integer id) {
		return professeurService.getById(id);
	}

	/**
	 * Delete By id
	 * @param id
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name="id") Integer id) {
		professeurService.delete(id);
	}
	/**
	 * 
	 * @param login and password
	 */
//	@PostMapping(value="/auth/login")
//	public Professeur authProf(@RequestBody String login, String password) {
//		return professeurService.AuthProfesseur(login, password);
//	}

	/**
	 * get file By Objet
	 * @param multipartFile
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping(value = "/file")
	public void getFile(@RequestBody Pressence absence ) {
		String matiers, hourbegin, beghour, endhour, currentDirectory ,nameImage,timeStamp, niveau;	
		byte[] image;
		String[] absencesArry;
		int idprof;
		currentDirectory = System.getProperty("user.dir");
		
		image = Base64.decode(absence.getFile());
		matiers = absence.getMatiere();
		beghour = absence.getBeghour();
		endhour = absence.getEndhour();
		idprof = absence.getIdProf();
		niveau = absence.getNiveau();
		System.out.println(idprof+" "+niveau);
		
		try {
			
			timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			nameImage = "absence"+timeStamp;
			File destFile = new File(currentDirectory + "\\gestionPresence\\FacialRecognition\\image\\"+nameImage+".jpg");
			InputStream ins = new ByteArrayInputStream(image);
			BufferedImage bImageFromConvert = ImageIO.read(ins);
			ImageIO.write(bImageFromConvert, "jpg", destFile);
			this.runScriptTraining();
			absencesArry = this.runScript(nameImage);
//			Integer[] idPresence = new Integer[absencesArry.length];
			if( absencesArry != null) {
				
				Matiere matiereAbs = matiereService.findByName(matiers);
				Niveau niveauAbs = niveauService.findNiveauByName(niveau);
				List<Seance>  listSeance = seanceService.getSeanceByIdProf(7);
				Seance seance = new Seance();
				System.out.println(niveauAbs.getId());
				for (Seance seanc : listSeance) {
					
					if(beghour.equals(seanc.getHeureDebut()) && endhour.equals(seanc.getHeureFin())) {
						seance = seanc;
					}else {
						System.out.println(seanc.getHeureDebut());
					}
				}
				
				List<Etudiant>  listEtudiant = etudiantService.getLisEtudtByNiveau(niveauAbs.getId());
//				Justification justification = new Justification();
//				System.out.println(Arrays.toString(absencesArry));
//				listEtudiant.remove(Arrays.asList(absencesArry));
				String Justif ="non";

				for (Etudiant etud : listEtudiant) {
					Absence absec = new Absence();
					absec.setHeure_debut(beghour);
					absec.setHeure_Fin(endhour);
					absec.setDate_absence(new Date());
					absec.setSeance(seance);
					absec.setEtudiant(etud);
					System.out.println(Arrays.asList(absencesArry).contains(Integer.toString(etud.getId())));
					if(Arrays.asList(absencesArry).contains(Integer.toString(etud.getId()))) {
						absec.setEtat(false);
						System.out.println(etud.getId());
					}else {
						absec.setEtat(true);
//						System.out.println(etud.getId());
					}
					absec.setJustif(Justif);
					System.out.println(absec);
					absenceService.save(absec);
				}
				
				
				
			}
			System.out.println(Arrays.toString(absencesArry));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void runScriptTraining() throws IOException {
		String currentDirectory = null ;
		currentDirectory = System.getProperty("user.dir");
		String[] cmd1 = {
			      "python",
			      currentDirectory+"\\gestionPresence\\FacialRecognition\\02_face_training.py",
			      
			    };

		Process p =Runtime.getRuntime().exec(cmd1);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			
			System.out.println(s);
		}
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}

	}
	
	public String[] runScript(String nameImage) throws IOException {
		String currentDirectory = null ;
		String[] values = null;
		currentDirectory = System.getProperty("user.dir");

		String[] cmd2 = {
			      "python",
			      currentDirectory+"\\gestionPresence\\FacialRecognition\\03_face_recognition.py",
			      nameImage,
			    };
		Process p = Runtime.getRuntime().exec(cmd2);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			s = s.replace("[", "").replace("]", "").replace(" ", "");
			values = s.split(",");
			System.out.println(values);
		}
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
		return values;

	}
	
	

}
