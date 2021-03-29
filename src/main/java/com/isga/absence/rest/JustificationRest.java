package com.isga.absence.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isga.absence.entity.Justification;
import com.isga.absence.service.JustificationService;

@RestController
@RequestMapping(value = "/justification")
@CrossOrigin(origins = "*")
public class JustificationRest {
	
	
	@Autowired
	private JustificationService justificationService;
	
	@GetMapping(value = "/list")
	public List<Justification> getAll(){
		
		return justificationService.getAll();
	}
	

	/**
	 * save & update
	 * @param just
	 * @return
	 */
	@PostMapping(value = "/save")
	public Justification save(@RequestBody Justification just) {
		return justificationService.save(just);		
	}
	
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Justification getById(@PathVariable("id") Integer id) {
		return justificationService.getById(id);
	}
	/**
	 * Delete By Objet
	 * @param sems
	 */
	@PostMapping(value = "/delete")
	public void delete(@RequestBody Justification just) {
		justificationService.delete(just);
	}

}
