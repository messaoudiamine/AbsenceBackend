package com.isga.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.absence.entity.User;
import com.isga.absence.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	/**
	 * save & update
	 * @param etudiant
	 * @return
	 */
	public User save(User user) {
		return userRepo.save(user);		
	}
	
	/**
	 * Get all
	 * @return collection
	 */
	public List<User> getAll(){
		
		return userRepo.findAll();
	}
	
	/**
	 * Find a user by id
	 * @param id
	 * @return
	 */
	public User getById(Integer id) {
		return userRepo.findById(id).orElse(null);
	}
	/**
	 * Delete By Id
	 * @param id
	 */
	public void deleteByid(Integer id) {
		userRepo.deleteById(id);
	}
	
	/**
	 * Find by email and password 
	 * @param Email and password
	 */
	public User findByEmailAndPassword(String email, String password) {
		return  userRepo.findByEmailAndPassword(email, password);
	}
}
