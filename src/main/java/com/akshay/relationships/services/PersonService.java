package com.akshay.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akshay.relationships.models.Person;
import com.akshay.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List <Person> getAllPeople() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

}
