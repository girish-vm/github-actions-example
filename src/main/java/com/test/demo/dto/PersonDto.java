/**
 * 
 */
package com.test.demo.dto;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 002SQF744
 *
 */
@Data
public class PersonDto {
	private int id;
	private String firstName;
	private String lastName;
	private ArrayList<String>phoneNumbers=new ArrayList<>();
}
