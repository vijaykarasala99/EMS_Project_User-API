package com.vijayit.dto;

import java.time.LocalDateTime;

import com.vijayit.entity.BranchEntity;
import com.vijayit.entity.DepartmentEntity;
import com.vijayit.entity.OrganizationEntity;
import com.vijayit.entity.RoleEntity;
import com.vijayit.entity.UserEntity;

public class UserDTO {
	
    private Integer userId;
    private byte[] image;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String isActive;
    private String isDeleted;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    
    private OrganizationEntity organization;
    private BranchEntity branch;
    private DepartmentEntity department;
    private RoleEntity role;

    
    // Constructor to initialize fields from UserEntity
    public UserDTO(UserEntity user) {
        this.userId = user.getUserId();
        this.image = user.getImage();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.password = user.getPassword();
        
        this.isActive = user.getIsActive() != null ? (user.getIsActive() ? "Active" : "Inactive") : "Unknown";
        this.isDeleted = user.getIsDeleted() != null ? (user.getIsDeleted() ? "Deleted" : "Not Deleted") : "Unknown";
        
        this.createdBy = user.getCreatedBy();
        this.updatedBy = user.getUpdatedBy();
        this.createdDate = user.getCreatedDate();
        this.updatedDate = user.getUpdatedDate();
        this.organization = user.getOrganization();
        this.branch = user.getBranch();
        this.department = user.getDepartment();
        this.role = user.getRole();
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
   
}