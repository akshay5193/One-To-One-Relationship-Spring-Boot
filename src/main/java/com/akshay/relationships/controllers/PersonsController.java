package com.akshay.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.relationships.models.Person;
import com.akshay.relationships.services.PersonService;

@Controller
public class PersonsController {

	private final PersonService personService;

	public PersonsController(PersonService personService) {
		this.personService = personService;
	}
	
	
	@GetMapping ("/persons")
	public String allPeople(Model model) {
		List<Person> persons = personService.getAllPeople();
		model.addAttribute("persons", persons);
		return "/persons/allPeople.jsp";
	}
	
	
	@GetMapping (value="/persons/new")
	public String addNewPersonPage(@ModelAttribute ("person") Person person) {
		return "/persons/newPerson.jsp";
	}
	
	
	@PostMapping (value="/persons")
	public String addNewPerson (@Valid @ModelAttribute ("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "persons/new";
		}
		else {
			personService.createPerson(person);
			return "redirect:/persons";
		}
	}
	
	
	
	
}
