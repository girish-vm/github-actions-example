/**
 * 
 */
package com.test.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Repository.PersonRepository;
import com.test.demo.entity.Person;
import com.test.demo.exception.PersonNotFoundException;

/**
 * @author 002SQF744
 *
 */

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public Person savePerson(Person p) {
		return personRepository.save(p);

	}

	public List<Person> getAllPerson() throws PersonNotFoundException {
		List<Person> g = personRepository.findAll();
		if (g != null) {
			return g;
		}
		{
			throw new PersonNotFoundException("dats is not existed!!! it is empty in db");
		}
		// System.out.println("person count"+g);

	}

	public Optional<Person> getPersonByid(int id) {
		// TODO Auto-generated method stub
		//return personRepository.findById(id);
		return personRepository.findByidUsingQuery(id);
	}
	
	public List<Person>getPeronsByName(String name)
	{
		return personRepository.getPersonsByName(name);
	}

}
