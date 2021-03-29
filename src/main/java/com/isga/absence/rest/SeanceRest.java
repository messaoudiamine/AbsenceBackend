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

import com.isga.absence.entity.Seance;
import com.isga.absence.service.SeanceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/seance")
public class SeanceRest {
	
	
	@Autowired
	private SeanceService seanceService; 
	
	/**
	 * save & update
	 * @param seance
	 * @return
	 */
	@PostMapping(value = "/save")
	public Seance save(@RequestBody Seance seance) {
		return seanceService.save(seance);		
	}
	
	/**
	 * save & update
	 * @param seance
	 */
	@PostMapping(value = "/save/image")
	public String saveImage(@RequestBody String image) {
		 return seanceService.saveImg(image);		
	}
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Seance> getAll(){
		
		return seanceService.getAll();
	}
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Seance getById(@PathVariable("id") Integer id) {
		return seanceService.getById(id);
	}
	/**
	 * Delete By Objet
	 * @param seance
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name="id") Integer id) {
		seanceService.delete(id);
	}

}
