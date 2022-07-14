package com.prueba.demo.service.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.prueba.demo.ConstantException.*;
import com.prueba.demo.entity.Person;
import com.prueba.demo.exception.PersonNotFoundException;
import com.prueba.demo.exception.PersonPasswordErrorException;
import com.prueba.demo.repository.PersonCRUDRepository;
import com.prueba.demo.service.PersonService;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonCRUDRepository personCRUDRepository;
	
	
	
	//°Consultas CRUD
	@Override
	public Person createPerson(Person person, String passwordConfirmation) throws Exception, PersonPasswordErrorException {
		if(checkPasswordValid(person,passwordConfirmation)) {
			System.out.println("Validacion exitosa");
		}
		return personCRUDRepository.save(person);
	}

	@Override
	public Person updatePerson(Person fromPerson) throws Exception, PersonNotFoundException {
		// TODO Auto-generated method stub
		Person toPerson=getPersonById(fromPerson.getId());
		mapPerson(fromPerson, toPerson);
		return personCRUDRepository.save(toPerson);
	}

	@Override
	public void deletePerson(Long personId) throws Exception, PersonNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPersonById(Long personId) throws Exception, PersonNotFoundException {
		// TODO Auto-generated method stub
		return personCRUDRepository.findById(personId).orElseThrow(() -> new  PersonNotFoundException(PERSON_NOT_FOUND));
	}

	//Utileria
	protected void mapPerson(Person from, Person to) {
//		°Atributos primarios
		to.setName(from.getName());
		to.setLastname(from.getName());
//		°Relaciones
	}
	
	private boolean checkPasswordValid(Person person, String passwordConfirmation) throws PersonPasswordErrorException {
		if(passwordConfirmation.isEmpty()| passwordConfirmation == null ) {
			throw new PersonPasswordErrorException(PERSON_PASSWORD_ERROR_NOT_PRESENT);
		}
		if(!person.getPassword().equals(passwordConfirmation)) {
			throw new PersonPasswordErrorException(PERSON_PASSWORD_ERROR_NOT_EQUALS);
		}
		return true;
	}
	
}
