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

import com.isga.absence.entity.User;
import com.isga.absence.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost")
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping(value = "/auth")
public class UserRest {
	
	@Autowired
	private UserService UserService;
	
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<User> getAll(){
		
		return UserService.getAll();
	}
	

	/**
	 * save & update
	 * @param etudiant
	 * @return
	 */
	@PostMapping(value = "/save")
	public User save(@RequestBody User user) {
		return UserService.save(user);		
	}
	
	
	/**
	 * Find a user by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public User getById(@PathVariable("id") Integer id) {
		return UserService.getById(id);
	}
	
	/**
	 * Delete By id
	 * @param User
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void deleteByid(@PathVariable(name="id") int id) {
		UserService.deleteByid(id);
	}
	
	/**
	 * Find by email and password 
	 * @param Email and password
	 */
	@CrossOrigin(origins = "http://localhost:8100/login")
	@GetMapping(value = "/login")
	public User findByEmailAndPassword(String email, String password) {
		System.out.println("test password");
		return  UserService.findByEmailAndPassword(email, password);
	}	

}
