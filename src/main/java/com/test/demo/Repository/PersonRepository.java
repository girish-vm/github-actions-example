/**
 * 
 */
package com.test.demo.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.demo.entity.Person;

/**
 * @author 002SQF744
 *
 */

  public interface PersonRepository extends MongoRepository<Person, Integer>
  {
	  
  }