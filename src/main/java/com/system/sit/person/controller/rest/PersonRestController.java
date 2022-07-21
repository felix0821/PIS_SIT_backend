package com.system.sit.person.controller.rest;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.sit.persistence.main.entity.Person;
import com.system.sit.person.dto.PersonFormRegisterDTO;
import com.system.sit.person.dto.PersonFormUpdateDTO;
import com.system.sit.person.dto.PersonViewDTO;
import com.system.sit.person.dto.PruebaDTO;
import com.system.sit.person.exception.PersonNotFoundException;
import com.system.sit.person.exception.PersonPasswordErrorException;
import com.system.sit.person.generic.Message;
import com.system.sit.person.service.PersonService;
import com.system.sit.utility.UniqIdUtility;

import static  com.system.sit.ConstantMapping.*;
import static  com.system.sit.ConstantException.*;
import static  com.system.sit.DefinitionReturn.*;
@RestController
@RequestMapping(value=URL_PERSON_REQUEST)
public class PersonRestController {
	 
	@Autowired
	private PersonService personService;
	@Autowired 
	UniqIdUtility uI;

	
	@SuppressWarnings(value={ "rawtypes", "unchecked" })
	@GetMapping(value=URL_PERSON_LIST_GET)
	public  ResponseEntity<?> list() {
		List<PruebaDTO> allPersonDTO=null;
		try {
			allPersonDTO=new ArrayList<PruebaDTO>();
			Iterable<Person>  allPerson= personService.getAllPerson();
		
			for(Person p:allPerson) {
				allPersonDTO.add(new PruebaDTO(p.getPersonId().toString()));
			}	
			allPerson=null;
			return new ResponseEntity<List<PruebaDTO>>( allPersonDTO, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		finally {
			allPersonDTO=null;
		}
		
		
	}
	
	@SuppressWarnings(value={"rawtypes", "unchecked" })
	@GetMapping(value=URL_PERSON_VIEW_GET)
	public  ResponseEntity<?> view(@RequestParam(name ="id")Long id) {
		PersonViewDTO personDTO=null;
		try {
			Person person=personService.getPersonById(id);
			personDTO=new PersonViewDTO(person.getPersonId(),person.getPersonName(),person.getPersonPassword());
			person=null;
			return new ResponseEntity<PersonViewDTO>( personDTO, HttpStatus.OK);
		}
		catch(PersonNotFoundException e){
			return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		 }
		finally{
			 personDTO=null;
			 
		}
			
	}
	
	@SuppressWarnings(value={"rawtypes", "unchecked" })
	@PostMapping(value=URL_PERSON_SAVE_POST)
	public ResponseEntity<?> save(@Valid @RequestBody PersonFormRegisterDTO personFormRegisterDTO, BindingResult bindingResult){
	 try{
//			°Realizamos las validaciones pertinentes
		 if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		 Long personId = uI.getUniqId();
		 Person person=new Person(personId);
		 person.setPersonName(personFormRegisterDTO.getName());
		 person.setPersonLastnameFather(personFormRegisterDTO.getLastname());
		 person.setPersonPassword(personFormRegisterDTO.getPassword());
		 personService.createPerson(person,personFormRegisterDTO.getConfirmation());
		 personFormRegisterDTO=null;
		 person=null;//para que no ocupe memoria
		 return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
	 }catch(PersonPasswordErrorException e){
		 return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
	 }catch(Exception e) {
		 e.printStackTrace();
		 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
	 }
	
	}
	
	@SuppressWarnings(value={"rawtypes", "unchecked" })
	@PutMapping(value=URL_PERSON_UPDATE_PUT )
	public ResponseEntity<?> update(@Valid @RequestBody PersonFormUpdateDTO personFormUpdateDTO, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
			Person person=personService.getPersonById(personFormUpdateDTO.getId());
			person.setPersonName(personFormUpdateDTO.getName());
			person.setPersonLastnameFather(personFormUpdateDTO.getLastname());
			personFormUpdateDTO=null;
			personService.updatePerson(person);
			person=null;
			return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
		}
		catch(PersonNotFoundException e){
			return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e ) {
			e.printStackTrace();
			 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value= URL_PERSON_DELETE_DELETE)
	public ResponseEntity<?> delete(@RequestParam(name ="id")Long id){
		try {
			personService.deletePerson(id);
			return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
		}
		catch(PersonNotFoundException e) {
			return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}

