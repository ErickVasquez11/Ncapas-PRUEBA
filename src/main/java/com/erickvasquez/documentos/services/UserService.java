package com.erickvasquez.documentos.services;

import com.erickvasquez.documentos.model.dto.RegisterDTO;
import com.erickvasquez.documentos.model.entities.User;

public interface UserService {

	void register(RegisterDTO info);
	User findOneById(String id);
	static Object getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
