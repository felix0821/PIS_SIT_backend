package com.system.sit.person.dto;

import javax.validation.constraints.NotNull;
import com.system.sit.person.dto.PersonFormDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonFormUpdateDTO  extends PersonFormDTO{
	@NotNull(message = "Ingrese un id valido")
	private Long id;
		

}
