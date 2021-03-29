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

import com.isga.absence.entity.Niveau;
import com.isga.absence.service.NiveauService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/niveau")
public class NiveauRest {
	
	@Autowired
	private NiveauService niveauService; 
	
	/**
	 * save & update
	 * @param niveau
	 * @return
	 */
	@PostMapping(value = "/save")
	public Niveau save(@RequestBody Niveau niveau) {
		return niveauService.save(niveau);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Niveau> getAll(){
		
		return niveauService.getAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	public Niveau getById(@PathVariable Integer id) {
		return niveauService.getById(id);
	}
	/**
	 * Delete By Objet
	 * @param id
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name="id") Integer id) {
		niveauService.deleteByid(id);
	}
	

}
