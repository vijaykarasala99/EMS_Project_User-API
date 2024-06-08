package com.vijayit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "branch")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(nullable = false, length = 100)
    private String branchName;

    
    
	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchEntity(Integer branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


}
