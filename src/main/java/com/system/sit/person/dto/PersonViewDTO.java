package com.system.sit.person.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonViewDTO {
	private long id;
	private String name;
	private String password;
	
	public PersonViewDTO(long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	

}