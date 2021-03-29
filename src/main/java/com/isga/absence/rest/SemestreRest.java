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

import com.isga.absence.entity.Semestre;
import com.isga.absence.service.SemestreService;

@RestController
@RequestMapping(value = "/semestre")
@CrossOrigin(origins = "*")
public class SemestreRest {
	
	@Autowired
	private SemestreService semestreService;
	
	@GetMapping(value = "/list")
	public List<Semestre> getAll(){
		
		return semestreService.getAll();
	}
	

	/**
	 * save & update
	 * @param sems
	 * @return
	 */
	@PostMapping(value = "/save")
	public Semestre save(@RequestBody Semestre sems) {
		return semestreService.save(sems);		
	}
	
	
	/**
	 * Find a semester by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Semestre getById(@PathVariable("id") Integer id) {
		return semestreService.getById(id);
	}
	/**
	 * Delete By Objet
	 * @param sems
	 */
	@PostMapping(value = "/delete")
	public void delete(@RequestBody Semestre sems) {
		semestreService.delete(sems);
	}
	

}
