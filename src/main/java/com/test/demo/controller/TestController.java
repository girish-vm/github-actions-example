/**
 * 
 */
package com.test.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.Service.PersonService;
import com.test.demo.entity.Person;
import com.test.demo.exception.PersonNotFoundException;

/**
 * @author 002SQF744
 *
 */
@RestController
public class TestController {
	@Autowired
	PersonService personService;

	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);

	}

	@GetMapping("/getAllPersons")
	public List<Person> getAllPerson() {
		try {
			return personService.getAllPerson();
		} catch (PersonNotFoundException personNotFoundException) {
			System.out.println(personNotFoundException.getMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return personService.getAllPerson();
	}

	@GetMapping("/getPerson/{id}")
	public Optional<Person> getPersonByid(@PathVariable("id") int id) {
		return personService.getPersonByid(id);

	}

}
