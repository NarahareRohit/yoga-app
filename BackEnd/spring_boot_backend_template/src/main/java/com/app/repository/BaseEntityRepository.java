package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.BaseEntity;
import com.app.entities.BatchEntity;

@Repository
public interface BaseEntityRepository extends JpaRepository<BatchEntity, Long> {

}
