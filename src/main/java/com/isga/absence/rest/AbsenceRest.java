package com.isga.absence.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isga.absence.entity.Absence;
import com.isga.absence.service.AbsenceService;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor.ForAttachment;

@RestController
@RequestMapping(value = "/absence")
@CrossOrigin(origins = "http://localhost:4200")
public class AbsenceRest {


	@Autowired
	private AbsenceService absenceService;


	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Absence> getAll(){

		return absenceService.getAll();
	}


	/**
	 * save & update
	 * @param absence
	 * @return
	 */
	@PostMapping(value = "/save")
	public Absence save(@RequestBody Absence absence) {
		return absenceService.save(absence);		
	}


	/**
	 * Find a annee by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Absence getById(@PathVariable("id") Integer id) {
		return absenceService.getById(id);
	}
	/**
	 * Delete By Objet
	 * @param absence
	 */
	@PostMapping(value = "/delete")
	public void delete(@RequestBody Absence absence) {
		absenceService.delete(absence);
	}
	/**
	 * List Absences By id niveau
	 * @param id etudiant
	 */
//	@GetMapping(value = "listeAbsence/{id}")
//	public List<Absence> getEtudtByNiveau(@PathVariable("id") Integer id) {
//		return absenceService.getListAbsenceByNiveau(id);
//	}
	
	/**
	 * Get list of presence
	 * @return 
	 * @throws IOException
	 */
	@GetMapping(value = "/listpresence")
	public String[] getAbsencePy(String nameImage) throws IOException {
		String[] values = null;
		nameImage = "mohamed2";
		String currentDirectory = System.getProperty("user.dir");
		String[] cmd = {
			      "python",
			      currentDirectory+"\\gestionPresence\\FacialRecognition\\03_face_recognition.py",
			      nameImage,
			    };
		Process p = Runtime.getRuntime().exec(cmd);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			s = s.replace("[", "").replace("]", "");
			values = s.split(",");
		}
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}

		return values;
	}

}
