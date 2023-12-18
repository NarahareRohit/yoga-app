package com.app.service;

import java.util.List;

import com.app.dto.UserDto;
import com.app.entities.User;

public interface UserService {

	User addUser(UserDto user);

	List<User> findUser();


}
