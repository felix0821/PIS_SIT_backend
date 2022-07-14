package com.prueba.demo.exception;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 1311235985461794334L; //Ayuda anserializar las clases 
	public   PersonNotFoundException(String message) {
		super(message);
		
		
	}
}
