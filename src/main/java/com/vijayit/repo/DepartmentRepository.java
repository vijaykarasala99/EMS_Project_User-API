package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
