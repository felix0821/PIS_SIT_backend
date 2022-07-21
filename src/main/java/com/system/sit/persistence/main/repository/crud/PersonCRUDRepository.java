package com.system.sit.persistence.main.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.sit.persistence.main.entity.Person;

@Repository
public interface PersonCRUDRepository extends CrudRepository<Person,Long> {
	
	public Optional<Person> findByPersonId(Long personId);
	
	public Optional<Person> findByPersonUsername(String personUsername);
	
	public boolean existsByPersonUsername(String personUsername);

}
