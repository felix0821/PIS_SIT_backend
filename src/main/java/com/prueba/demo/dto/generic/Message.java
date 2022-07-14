package com.prueba.demo.dto.generic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
public class Message {
	
	private String content;

	public Message(String content) {
		super();
		this.content = content;
	}
	
	
	
	
	
	
	
}
