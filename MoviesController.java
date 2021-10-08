package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Movies;

@RestController
@RequestMapping("/movies")

public class MoviesController {
	private List<Movies> listOfMovies = new ArrayList();
	
	MoviesController(){
		listOfMovies.add(
				new Movies("Naruto Shippuden","Saga Shippuden","1842")
				);
		listOfMovies.add(
				new Movies("Naruto Akatsuki","Saga Akatsuki","1920")
				);
		listOfMovies.add(
				new Movies("Sasuke Uchiha History","Uchiha Family","1542")
				);
	}
	@GetMapping
	public List<Movies> findAll(){
		return listOfMovies;
	}
	
	@GetMapping("/{name}")
	public Movies findOne(@PathVariable String name) {
		for(Movies movie : listOfMovies) {
			if(movie.getMovie().equalsIgnoreCase(name)) {
				return movie;
			}
		}
		return null;
	}
	
	@PostMapping
	public Map<String, String> insert(@RequestBody Movies movie){
		Map<String,String> result = new HashMap<String,String>();
		boolean isSucess = listOfMovies.add(movie);
		if(isSucess) {
			result.put("result", "Filme cadastrado com sucesso!!!");
		}else {
			result.put("result", "Não foi possivel cadastrar o Filme!!!");
		}
		return result;
	}
	
	@PutMapping
	public Map<String, String> edit(@RequestBody Movies movie){
		Map<String, String> result = new HashMap<String, String>();
		
		for(Movies element1 : listOfMovies) {
			if(element1.getName().equalsIgnoreCase(movie.getName())) {
				int index = listOfMovies.indexOf(element1);
				listOfMovies.set(index, movie);
				result.put("result", "Filme Editado com sucesso!");
				return result;
			}
		}
		result.put("result", "Não foi possivel editar!!");
		return result;
	}	
}
	