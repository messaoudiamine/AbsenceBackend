package com.isga.absence.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isga.absence.entity.Matiere;
import com.isga.absence.service.MatiereService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/matiere")
//@CrossOrigin(origins = "http://localhost:4200")
public class MatiereRest {
	

	@Autowired
	private MatiereService matiereService; 
	
	/**
	 * save & update
	 * @param mat
	 * @return
	 */
	@PostMapping(value = "/save")
	public Matiere save(@RequestBody Matiere mat) {
		return matiereService.save(mat);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Matiere> getAll(){
		
		return matiereService.getAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Matiere getById(@PathVariable Integer id) {
		return matiereService.getById(id);
	}
	/**
	 * Delete By id
	 * @param mat
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name="id") Integer id) {
		matiereService.delete(id);
	}

}
