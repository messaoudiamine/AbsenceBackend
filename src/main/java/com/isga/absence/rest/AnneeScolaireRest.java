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

import com.isga.absence.entity.AnneeScolaire;
import com.isga.absence.service.AnneeScolaireService;

@RestController
@RequestMapping(value = "/anneescolaire")
@CrossOrigin(origins = "*")
public class AnneeScolaireRest {
	
	@Autowired
	private AnneeScolaireService anneeScolaireService;
	
	@GetMapping(value = "/list")
	public List<AnneeScolaire> getAll(){
		
		return anneeScolaireService.getAll();
	}
	

	/**
	 * save & update
	 * @param annesco
	 * @return
	 */
	@PostMapping(value = "/save")
	public AnneeScolaire save(@RequestBody AnneeScolaire annesco) {
		return anneeScolaireService.save(annesco);		
	}
	
	
	/**
	 * Find a annee by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public AnneeScolaire getById(@PathVariable("id") Integer id) {
		return anneeScolaireService.getById(id);
	}
	/**
	 * Delete By ID
	 * @param annesco
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name="id") int id) {
		anneeScolaireService.delete(id);
	}

}
