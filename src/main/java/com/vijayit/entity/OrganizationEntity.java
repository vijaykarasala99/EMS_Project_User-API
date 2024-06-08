package com.vijayit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")
public class OrganizationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organization_id")
	private Integer organizationId;

	@Column(nullable = false, length = 100)
	private String organizationName;
	
	
	

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public OrganizationEntity(Integer organizationId, String organizationName) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}

	public OrganizationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}