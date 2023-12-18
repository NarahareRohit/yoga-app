package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.BaseEntity;
import com.app.entities.BatchEntity;
import com.app.entities.BatchEnum;
import com.app.repository.BaseEntityRepository;

@Service
@Transactional
public class BaseEntityServiceImpl implements BaseEntityService {

	@Autowired
	private BaseEntityRepository baseentityrepo;

	@Override
	public List<BatchEntity> initCategories() {
		List<BatchEntity> init = new ArrayList<>();
		if (baseentityrepo.count() == 0) {
			Arrays.stream(BatchEnum.values()).forEach(categoryNameEnum -> {
				BatchEntity baseEntity = new BatchEntity(categoryNameEnum);
				this.baseentityrepo.save(baseEntity);
				init.add(baseEntity);
			});

		}
		return init;
	}
	
	
	
	
	
}
