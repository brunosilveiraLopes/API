package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/")

public class HomeController {
	@GetMapping
	public String index( ) {
		return "Bem-vindo ao meu Site!. Temos Disponiveis o "
				+ "http://localhost:8080/movies/,"
				+ "http://localhost:8080/person/,"
				+ "http://localhost:8080/Natural/";
		
	}


}
