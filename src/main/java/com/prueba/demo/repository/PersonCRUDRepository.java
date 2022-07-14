package com.prueba.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.entity.Person;

@Repository
public interface PersonCRUDRepository extends CrudRepository<Person,Long> {

	

	
	
}
