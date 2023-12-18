package com.app.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repository.BaseEntityRepository;
import com.app.service.BaseEntityService;

@Component
public class Dbinit implements CommandLineRunner {

	@Autowired
	private BaseEntityService baseentityservice;

	@Override
	public void run(String... args) throws Exception {
		baseentityservice.initCategories();
	}
}
