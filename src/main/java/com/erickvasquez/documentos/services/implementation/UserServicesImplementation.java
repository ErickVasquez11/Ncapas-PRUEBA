package com.erickvasquez.documentos.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.erickvasquez.documentos.model.dto.RegisterDTO;
import com.erickvasquez.documentos.model.entities.User;
import com.erickvasquez.documentos.services.UserService;

@Service
public class UserServicesImplementation implements UserService {

	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User("carlitos","carlitos@google.com","Carlos perez","12345"));
		users.add(new User("jaun","carlitosss@google.com","juan carlos perez","123435"));
		users.add(new User("Pedro","carlitosss@google.com","juan carlos perez","123445"));
	}
	
	@Override
	public void register(RegisterDTO info) {
		User newUser = new User(
					info.getUsername(),
					info.getEmail(),
					null,
					info.getPassword() + "_encrypted"
					);
		
		users = Stream.concat(users.stream(), Stream.of(newUser))
				.collect(Collectors.toList());
	}
	
	@Override
	public User findOneById(String id) {
		return users.stream()
				.filter(u -> (u.getUsername().equals(id) || u.getEmail().equals(id) ))
				.findAny()
				.orElse(null);
	}


}
