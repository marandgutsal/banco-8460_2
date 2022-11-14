package com.example.demo.modelo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Empleado2 {

    @RequestMapping("/123456")
    public String hola() {
        return "Hola Mundo!";
    }
    
}