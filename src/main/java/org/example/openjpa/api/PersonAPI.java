package org.example.openjpa.api;

import java.util.Collections;
import java.util.List;

import org.example.openjpa.entities.Person;
import org.example.openjpa.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAPI {

	@Autowired
	private PersonRepo personRepo;

	@GetMapping("/persons")
	public List<Person> findAll() {
		try {
			return personRepo.findAll();
		} catch (Exception e) {
			return Collections.EMPTY_LIST;
		}
	}

	@GetMapping("/person/{id}")
	public Person findById(@PathVariable long id) {
		try {
			return personRepo.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/person")
	public void add(@RequestBody Person newPerson) {
		try {
			personRepo.save(newPerson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
