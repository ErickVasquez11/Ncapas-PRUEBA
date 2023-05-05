package com.erickvasquez.documentos.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDTO {
	private String username;
	private String email;
	private String password;
	
	@NotEmpty(message = "Identifier Required")
	private String identifier;
}
