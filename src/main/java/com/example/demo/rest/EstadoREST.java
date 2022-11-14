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

import com.example.demo.modelo.Estado;
import com.example.demo.modelo.User;
import com.example.demo.servicio.EstadoServicio;

@RestController
@RequestMapping ("/api/estado/")
public class EstadoREST {
	
	@Autowired
	private EstadoServicio estadoServicio;
	
	@PostMapping
	private ResponseEntity<Estado> guardar(@RequestBody Estado estado){
		Estado temporal = estadoServicio.create(estado);
		
		try {
			return ResponseEntity.created(new URI("/api/estado"+temporal.getId())).body(temporal);
		}catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	private ResponseEntity<List<Estado>> listarTodasLosEstado (){
		return ResponseEntity.ok(estadoServicio.getAllEstados());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarEstado (@RequestBody Estado estado){
		estadoServicio.delete(estado);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Estado>> listarEstadoPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(estadoServicio.findById(id));
	}
	
}