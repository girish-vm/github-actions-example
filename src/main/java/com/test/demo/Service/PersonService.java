/**
 * 
 */
package com.test.demo.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.demo.Repository.PersonRepository;
import com.test.demo.entity.Person;

/**
 * @author 002SQF744
 *
 */

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	public Person savePerson(Person p)
	{
		return personRepository.save(p);
		
	}
	

	
	public List<Person>getAllPerson()
	{
	List<Person>g= personRepository.findAll();
	System.out.println("person count"+g);
	return g;
	}



	public Optional<Person> getPersonByid(int id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}
	
}
