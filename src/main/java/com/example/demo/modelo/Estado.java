package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "estado")
public class Estado {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descripcion;

	
	
	
	
	
	
	
	
	
	
	
	
	public Estado(Long id, String descripcion) {
		// super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
