package com.isga.absence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isga.absence.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);

}
