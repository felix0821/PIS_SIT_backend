package com.system.sit.service.method;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.sit.persistence.main.entity.Person;
import com.system.sit.persistence.main.entity.PersonRole;
import com.system.sit.persistence.main.repository.crud.PersonCRUDRepository;
import com.system.sit.persistence.main.repository.crud.PersonRoleCRUDRepository;
import com.system.sit.security.JwtUser;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	PersonCRUDRepository personCRUDRepository;
	
	@Autowired
	PersonRoleCRUDRepository personRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String personUsername) throws UsernameNotFoundException {
    	Person person = personCRUDRepository.findByPersonUsername(personUsername).get();
    	Collection<PersonRole> personRoles = new ArrayList<PersonRole>();
    	personRoleRepository.findByPersonId(person.getPersonId()).forEach(personRoles::add);
        return JwtUser.build(person, personRoles);
    }
}