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

import com.example.demo.Model.Person;


@RestController
@RequestMapping("/person")
public class PersonController {
	private List<Person> listOfPersons = new ArrayList();

	PersonController(){
		listOfPersons.add(
				new Person("Naruto","Uzumaki","06/02/1854","narutouzumaki@gmail.com")
		);
	}

	@GetMapping
	public List<Person>findAll(){
		return listOfPersons;
	}
	
	@GetMapping("/{name}")
	public Person findOne(@PathVariable String name) {
		for(Person person : listOfPersons) {
			if(person.getName().equalsIgnoreCase(name)) {
				return person;
			}
		}
		return null;
	}
	
	@PostMapping
	public Map<String, String> insert(@RequestBody Person person){
		Map<String,String> result = new HashMap<String,String>();
		boolean isSucess = listOfPersons.add(person);
		if(isSucess) {
			result.put("result", "Pessoa cadastrada com sucesso!!!");
		}else {
			result.put("result", "Não foi possivel cadastrar a pessoa!!!");
		}
		return result;
	}
	
	@PutMapping
	public Map<String,String> edit(@RequestBody Person person){
		Map<String,String> result = new HashMap<String,String>();
		
		for(Person element : listOfPersons) {
			if(element.getName().equalsIgnoreCase(person.getName())) {
				int index = listOfPersons.indexOf(element);
				listOfPersons.set(index, person);
				result.put("result", "Pessoa Editada com sucesso!!!");
				return result;
			}
		}
		result.put("result","Não foi possível editar a pessoa!!");
		return result;
	}
	
}