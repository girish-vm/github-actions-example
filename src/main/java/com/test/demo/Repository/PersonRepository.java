/**
 * 
 */
package com.test.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.demo.entity.Person;

/**
 * @author 002SQF744
 *
 */

  public interface PersonRepository extends MongoRepository<Person, Integer>
  {
	  @Query("{id:?0}")
	Optional<Person> findByidUsingQuery(int id);
	  @Query("{firstName:?0}")
	 List<Person>getPersonsByName(String firstName) ;
  }