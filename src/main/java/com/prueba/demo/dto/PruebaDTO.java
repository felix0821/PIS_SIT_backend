package com.prueba.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import lombok.RequiredArgsConstructor;

@Getter
@Setter
@ToString
public class PruebaDTO {
	private String contenido;
	

	public PruebaDTO(String contenido) {
		super();
		this.contenido = contenido;
	}

	
	
	
	

}
