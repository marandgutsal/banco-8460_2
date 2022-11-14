package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estado;
import com.example.demo.repositorio.EstadoRepositorio;

@Service
public class EstadoServicio {

	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	
	
	
	
	
	
	
	
	
	

	public Estado create (Estado estado) {
		return estadoRepositorio.save(estado);
	}
	
	public List<Estado> getAllEstados () {
		return estadoRepositorio.findAll();
	}
	
	public void delete (Estado estado) {
		estadoRepositorio.delete(estado);
	}
	
	public Optional<Estado> findById(Long id) {
		return estadoRepositorio.findById(id);
	}
		

	
}
