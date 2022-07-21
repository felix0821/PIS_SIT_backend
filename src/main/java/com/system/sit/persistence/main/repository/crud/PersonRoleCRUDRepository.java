package com.system.sit.persistence.main.repository.crud;

import org.springframework.stereotype.Repository;

import com.system.sit.persistence.main.entity.PersonRole;
import com.system.sit.persistence.main.entity.PersonRolePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonRoleCRUDRepository extends JpaRepository<PersonRole,PersonRolePK>{
	
	public Iterable<PersonRole> findByPersonId(@Param("personId")long personId);
	
	public Iterable<PersonRole> findByRoleId(@Param("roleId")long roleId);
}
