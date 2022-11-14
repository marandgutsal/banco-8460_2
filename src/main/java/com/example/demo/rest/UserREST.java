package com.example.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.User;
import com.example.demo.servicio.UserServicio;

@RestController
@RequestMapping ("/api/user/")
public class UserREST {

	@Autowired
	private UserServicio userServicio;

	@PostMapping
	private ResponseEntity<User> guardar(@RequestBody User user){
		User temporal = userServicio.create(user);
		
		try {
			return ResponseEntity.created(new URI("/api/user"+temporal.getId())).body(temporal);
		}catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<User>> listarTodasLosUser (){
		return ResponseEntity.ok(userServicio.getAllUsers());
		
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarUser (@RequestBody User user){
		userServicio.delete(user);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<User>> listarUserPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(userServicio.findById(id));
		
	}
}