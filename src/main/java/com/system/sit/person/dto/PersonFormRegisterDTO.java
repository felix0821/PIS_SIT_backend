package com.system.sit.person.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.system.sit.person.dto.PersonFormDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonFormRegisterDTO extends PersonFormDTO {
	@NotBlank(message = "Ingrese un apellido paterno.")
	@Size(max = 128, message = "Él limite de carácteres para el apellido paterno no debe sobrepasar los 128.")
	@Size(min = 2, message = "El apellido paterno necesita al menos 2 caracteres.")
	private String password;
	@NotBlank(message = "Ingrese una confirmación de contraseña.")
	@Size(max = 128, message = "Él limite de carácteres para la contraseña no debe sobrepasar los 128.")
	@Size(min = 6, message = "La confirmación de Contraseña necesita al menos 6 caracteres.")
	private String confirmation;
}