package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelo.User;

public interface UserRepositorio extends JpaRepository<User, Long>{

}