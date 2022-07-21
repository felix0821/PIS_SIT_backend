package com.system.sit.person.service;

import com.system.sit.persistence.main.entity.Person;
import com.system.sit.person.exception.PersonNotFoundException;
import com.system.sit.person.exception.PersonPasswordErrorException;

public interface PersonService {
	
//	°Consultas CRUD
	public Person createPerson(Person person, String passwordConfirmation) throws Exception, PersonPasswordErrorException;
	public Person updatePerson(Person frontPerson) throws Exception, PersonNotFoundException;
	public void  deletePerson(Long personId) throws Exception, PersonNotFoundException;
	public Person getPersonById(Long personId) throws Exception, PersonNotFoundException;
	public Iterable<Person> getAllPerson();

}