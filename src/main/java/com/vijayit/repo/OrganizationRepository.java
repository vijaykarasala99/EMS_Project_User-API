package com.vijayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijayit.entity.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer>{

}
