
package com.test.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.Repository.PersonRepository;
import com.test.demo.Service.PersonService;
import com.test.demo.dto.PersonDto;
import com.test.demo.entity.Person;
import com.test.demo.exception.PersonNotFoundException;

@RunWith(SpringRunner.class)

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@Test
	public void getPersonTest() {
		List<Person> p = new ArrayList<>();
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers = TestApplicationTests.prepareArrayList();
		p.add(new Person(101, "girish", "kumar", phoneNumbers));
		p.add(new Person(102, "lohith", "kumar", phoneNumbers));

		when(personRepository.findAll()).thenReturn(p);
		assertEquals(2, personService.getAllPerson().size());

	}

	public static ArrayList<String> prepareArrayList() {
		ArrayList<String> phone = new ArrayList<String>();
		phone.add("1234");
		phone.add("2345");
		return phone;
	}

	public static PersonDto returnDtoData() {
		ArrayList<String> phone = new ArrayList<String>();
		phone.add("1234");
		phone.add("2345");
		PersonDto dto = new PersonDto();
		dto.setFirstName("laa");
		dto.setId(101);
		dto.setLastName("kumar");
		dto.setPhoneNumbers(phone);
		return dto;
	}

	@Test()
	public void getPersonTestException() {

		List<Person> p = new ArrayList<>();
		p.add(null);
		when(personRepository.findAll()).thenThrow(PersonNotFoundException.class);
		assertThrows(PersonNotFoundException.class, () -> personService.getAllPerson());

	}

	@Test
	public void savePerson() {
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers = TestApplicationTests.prepareArrayList();
		Person p = new Person(101, "laa", "kumar", phoneNumbers);
		PersonDto dtoData = new PersonDto();
		dtoData = TestApplicationTests.returnDtoData();
		when(personRepository.save(p)).thenReturn(p);
		assertEquals(p, personService.savePerson(dtoData));
	}

	@DisplayName("do return using id only")

	@Test
	public void getPersonById() {
		// int id=102;
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers = TestApplicationTests.prepareArrayList();
		// Optional<Person> p = Optional.of(new Person(102, "laa",
		// "kumar",phoneNumbers));
		Person pMock = new Person(102, "girish", "kuma", phoneNumbers);
		doReturn(Optional.of(pMock)).when(personRepository).findByidUsingQuery(pMock.getId());
		Optional<Person> pe = personService.getPersonByid(pMock.getId());
		assertEquals(102, pe.get().getId());
	}

	@DisplayName("GetPersonByName")
	@Test
	public void getPersonByName() {
		List<Person> mockList = new ArrayList<>();
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers = TestApplicationTests.prepareArrayList();
		Person pMock = new Person(101, "lokesh", "kuma", phoneNumbers);
		Person pMock1 = new Person(103, "lokesh", "kuma", phoneNumbers);
		mockList.add(pMock1);
		mockList.add(pMock);
		doReturn(mockList).when(personRepository).getPersonsByName("lokesh");
		List<Person> pe = personService.getPeronsByName("lokesh");
		assertEquals(mockList, pe);
	}

}
