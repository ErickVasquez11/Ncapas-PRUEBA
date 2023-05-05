package com.erickvasquez.documentos.
controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erickvasquez.documentos.model.dto.RegisterDTO;
import com.erickvasquez.documentos.model.dto.UserDTO;
import com.erickvasquez.documentos.model.entities.User;
import com.erickvasquez.documentos.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
public class LibraryController {

	@Autowired
	private UserService userService;

	@GetMapping("users")
	public ResponseEntity<?> findOneBookByIsbnAndUser(
			@Valid RegisterDTO search, BindingResult validations){
		
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User userFound = userService.findOneById(search.getIdentifier());
		if(userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		UserDTO response = new UserDTO(userFound);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
