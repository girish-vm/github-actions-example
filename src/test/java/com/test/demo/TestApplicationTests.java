package com.test.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.Repository.PersonRepository;
import com.test.demo.Service.PersonService;
import com.test.demo.entity.Person;
@RunWith(SpringRunner.class)
@SpringBootTest
class TestApplicationTests {
	@Autowired
	private PersonService personService;
	@MockBean
	private PersonRepository personRepository;
	
	@Test
	public void getPersonTest()
	{
		List<Person>p=new ArrayList<>();
		p.add(new Person(101,"girish","kumar"));
		p.add(new Person(102,"lohith","kumar"));
		
		when(personRepository.findAll()).thenReturn(p);
		assertEquals(2, personService.getAllPerson().size());
		
	}
	@Test
	public void savePerson()
	{
	Person p=new Person(102,"laa","kumar");
	when(personRepository.save(p)).thenReturn(p);
	assertEquals(p, personService.savePerson(p));
	}
	
	
	
}
