package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entities.BatchEntity;
import com.app.entities.User;
import com.app.repository.BaseEntityRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BaseEntityRepository baseentityrepo;

	@Override
	public User addUser(UserDto dto) {
		User user = mapper.map(dto, User.class);
		BatchEntity base = baseentityrepo.findById(new Long(dto.getBatch())).orElseThrow();
		System.out.println(user + "  " + base);
		user.setBatch(base);
		user.setDate(LocalDate.now());
		return userRepo.save(user);
	}

	@Override
	public List<User> findUser() {
		return userRepo.findAll();
	}

	
}
