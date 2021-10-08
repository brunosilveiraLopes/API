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

import com.example.demo.Model.Aldeia;

@RestController
@RequestMapping("/aldeia")

public class AldeiaController {
	private List<Aldeia> listOfAldeia = new ArrayList();
	
	AldeiaController(){
		listOfAldeia.add(
				new Aldeia("Saga Uzumaki","AKT")
				);
		listOfAldeia.add(
				new Aldeia("Saga Akatsuki","RTT")
				);
		listOfAldeia.add(
				new Aldeia("Uchiha Family","SEQ")
				);
	}
	@GetMapping
	public List<Aldeia> findAll(){
		return listOfAldeia;
	}
	
	@GetMapping("/{name}")
	public Aldeia findOne(@PathVariable String name) {
		for(Aldeia aldeia : listOfAldeia) {
			if(aldeia.getName().equalsIgnoreCase(name)) {
				return aldeia;
			}
		}
		return null;
	}
	
	@PostMapping
	public Map<String, String> insert(@RequestBody Aldeia aldeia){
		Map<String,String> result = new HashMap<String,String>();
		boolean isSucess = listOfAldeia.add(aldeia);
		if(isSucess) {
			result.put("result", "Filme cadastrado com sucesso!!!");
		}else {
			result.put("result", "Não foi possivel cadastrar o Filme!!!");
		}
		return result;
	}
	
	@PutMapping
	public Map<String, String> edit(@RequestBody Aldeia aldeia){
		Map<String, String> result = new HashMap<String, String>();
		
		for(Aldeia element3 : listOfAldeia) {
			if(element3.getName().equalsIgnoreCase(aldeia.getName())) {
				int index = listOfAldeia.indexOf(element3);
				listOfAldeia.set(index, aldeia);
				result.put("result", "Filme Editado com sucesso!");
				return result;
			}
		}
		result.put("result", "Não foi possivel editar!!");
		return result;
	}	
}
	