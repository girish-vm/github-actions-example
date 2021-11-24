/**
 * 
 */
package com.test.demo.exception;

/**
 * @author 002SQF744
 *
 */
public class PersonNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private String message;
	private static final long serialVersionUID = 1L;
	public PersonNotFoundException(String message) {
		super();
		this.message=message;
	}
	
	

}
