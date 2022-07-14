package com.prueba.demo.service;

import com.prueba.demo.entity.Person;
import com.prueba.demo.exception.PersonNotFoundException;
import com.prueba.demo.exception.PersonPasswordErrorException;


public interface PersonService {
	
//	°Consultas CRUD
	public Person createPerson(Person person, String passwordConfirmation) throws Exception, PersonPasswordErrorException;
	public Person updatePerson(Person frontPerson) throws Exception, PersonNotFoundException;
	public void  deletePerson(Long personId) throws Exception, PersonNotFoundException;
	public Person getPersonById(Long personId) throws Exception, PersonNotFoundException;

}