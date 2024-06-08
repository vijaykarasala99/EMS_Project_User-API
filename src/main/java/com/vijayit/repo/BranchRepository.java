package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{

}
