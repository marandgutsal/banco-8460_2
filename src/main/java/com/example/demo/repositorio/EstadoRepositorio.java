package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Estado;

public interface EstadoRepositorio extends JpaRepository<Estado, Long> {

}
