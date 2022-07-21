package com.system.sit.person.service.implement;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static  com.system.sit.ConstantException.*;
import com.system.sit.persistence.main.entity.Person;
import com.system.sit.persistence.main.repository.crud.PersonCRUDRepository;
import com.system.sit.person.exception.PersonNotFoundException;
import com.system.sit.person.exception.PersonPasswordErrorException;
import com.system.sit.person.service.PersonService;


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
		Person toPerson=getPersonById(fromPerson.getPersonId());
		mapPerson(fromPerson, toPerson);
		return personCRUDRepository.save(toPerson);
	}

	@Override
	public void deletePerson(Long personId) throws Exception, PersonNotFoundException {
		Person person=getPersonById(personId);
		personCRUDRepository.delete(person);		
	}

	@Override
	public Person getPersonById(Long personId) throws Exception, PersonNotFoundException {
		// TODO Auto-generated method stub
		return personCRUDRepository.findById(personId).orElseThrow(() -> new  PersonNotFoundException(PERSON_NOT_FOUND));
	}

	//Utileria
	protected void mapPerson(Person from, Person to) {
//		°Atributos primarios
		to.setPersonName(from.getPersonName());
		to.setPersonLastnameFather(from.getPersonName());
//		°Relaciones
	}
	
	private boolean checkPasswordValid(Person person, String passwordConfirmation) throws PersonPasswordErrorException {
		if(passwordConfirmation.isEmpty()| passwordConfirmation == null ) {
			throw new PersonPasswordErrorException(PERSON_PASSWORD_ERROR_NOT_PRESENT);
		}
		if(!person.getPersonPassword().equals(passwordConfirmation)) {
			throw new PersonPasswordErrorException(PERSON_PASSWORD_ERROR_NOT_EQUALS);
		}
		return true;
	}

	@Override
	public Iterable<Person> getAllPerson() {
		return personCRUDRepository.findAll();
	}
	
}

