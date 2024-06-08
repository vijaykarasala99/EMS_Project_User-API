package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
