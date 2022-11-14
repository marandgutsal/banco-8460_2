package com.example.demo.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.User;
import com.example.demo.repositorio.UserRepositorio;

//import antlr.collections.List;

@Service
public class UserServicio {

	@Autowired
	private UserRepositorio userRepositorio;
	
	public User create (User user) {
		return userRepositorio.save(user);
	}
	
	public List<User> getAllUsers () {
		return userRepositorio.findAll();
	}
	
	public void delete (User user) {
		userRepositorio.delete(user);
	}
	
	public Optional<User> findById(Long id) {
		return userRepositorio.findById(id);
	}
		
	
	
}
