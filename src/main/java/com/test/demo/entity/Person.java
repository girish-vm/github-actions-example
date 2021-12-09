/**
 * 
 */
package com.test.demo.entity;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 002SQF744
 *
 */
@Data
@AllArgsConstructor
@Document(collection = "Person")
public class Person {

	public Person() {
		super();
	}

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private ArrayList<String>phoneNumbers=new ArrayList<>();

}
