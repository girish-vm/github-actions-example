/**
 * 
 */
package com.test.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.Service.PersonService;
import com.test.demo.entity.Person;

/**
 * @author 002SQF744
 *
 */
@RestController
public class TestController {
	@Autowired
	PersonService personService;
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person)
	{
		return personService.savePerson(person);
		
	}
	
	@GetMapping("/getAllPersons")
	public List<Person>getAllPerson()
	{
		return personService.getAllPerson();
	}
	
	
	
	
}
