package com.prueba.demo.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.prueba.demo.ConstantMapping.*;
import static com.prueba.demo.DefinitionReturn.*;
import com.prueba.demo.dto.*;
import com.prueba.demo.dto.generic.Message;
import com.prueba.demo.entity.Person;
import com.prueba.demo.exception.PersonNotFoundException;
import com.prueba.demo.exception.PersonPasswordErrorException;
import com.prueba.demo.repository.PersonCRUDRepository;
import com.prueba.demo.service.PersonService;
import com.prueba.demo.utility.UniqIdUtility;

@RestController
public class MainRestController {
	@Autowired
	private PersonCRUDRepository personRepository;
	@Autowired
	private PersonService personService;
	@Autowired 
	UniqIdUtility uI;

	
	@GetMapping("/rest")
	public  ResponseEntity<List<PruebaDTO>> indexClass() {
		List<PruebaDTO> pdto=new ArrayList<PruebaDTO>();
		Iterable<Person> allPerson= personRepository.findAll();
		for(Person p:allPerson) {
			pdto.add(new PruebaDTO(p.getName()));
		}		
		return new ResponseEntity<List<PruebaDTO>>( pdto, HttpStatus.OK);
		
	}
	
	@PostMapping(value=URL_PERSON_REGISTER_POST)
	public ResponseEntity<?> save(@Valid @RequestBody PersonFormRegisterDTO personFormRegisterDTO, BindingResult bindingResult){
	 try{
//			°Realizamos las validaciones pertinentes
		 if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		 Long personId = uI.getUniqId();
		 Person person=new Person(personId);
		 person.setName(personFormRegisterDTO.getName());
		 person.setLastname(personFormRegisterDTO.getLastname());
		 person.setPassword(personFormRegisterDTO.getPassword());
		 personService.createPerson(person,personFormRegisterDTO.getConfirmation());
		 return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
	 }catch(PersonPasswordErrorException e){
		 return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
	 }catch(Exception e) {
		 e.printStackTrace();
		 return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
	 }
	
	}
	
	@PutMapping(value=URL_PERSON_REGISTER_PUT )
	public ResponseEntity<?> update(@Valid @RequestBody PersonFormUpdateDTO personFormUpdateDTO, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
			Person person=personService.getPersonById(personFormUpdateDTO.getId());
			personService.updatePerson(person);
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
	
	
	
}
