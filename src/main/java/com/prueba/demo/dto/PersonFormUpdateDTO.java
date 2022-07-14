package com.prueba.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonFormUpdateDTO  extends PersonForm{
	@NotNull(message = "Ingrese un id valido")
	private Long id;
		

}
