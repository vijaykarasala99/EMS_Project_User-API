package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
