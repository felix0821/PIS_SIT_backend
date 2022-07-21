package com.system.sit.person.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonFormDTO {
	@NotBlank(message = "Ingrese un nombre.")
	@Size(max = 128, message = "Él limite de carácteres para el nombre no debe sobrepasar los 128.")
	@Size(min = 2, message = "El nombre necesita al menos 2 caracteres.")
	private String name;
	@NotBlank(message = "Ingrese un apellido paterno.")
	@Size(max = 128, message = "Él limite de carácteres para el apellido paterno no debe sobrepasar los 128.")
	@Size(min = 2, message = "El apellido paterno necesita al menos 2 caracteres.")
	private String lastname;
	

}