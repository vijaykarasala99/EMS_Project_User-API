package com.vijayit.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	@Column(nullable = false, length = 50, name = "firstName")
	private String firstName;

	@Column(length = 50, name = "lastName")
	private String lastName;

	@Column(length = 50, unique = true)
	private String email;

	@Column(length = 50, name = "phoneNumber")
	private String phoneNumber;

	@Column(length = 500)
	private String password;

	@Column(name = "isActive")
	private Boolean isActive;

	@Column(name = "isDeleted")
	private Boolean isDeleted;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "updatedBy")
	private String updatedBy;

	@CreatedDate
	@Column(name = "createdDate", updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "organizationId", nullable = false)
	private OrganizationEntity organization;
	
	@ManyToOne
	@JoinColumn(name = "branchId", nullable = false)
	private BranchEntity branch;

	@ManyToOne
	@JoinColumn(name = "departmentId", nullable = false)
	private DepartmentEntity department;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	private RoleEntity role;

	

	
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
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

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public UserEntity(Integer userId, byte[] image, String firstName, String lastName, String email, String phoneNumber,
			String password, Boolean isActive, Boolean isDeleted, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate, RoleEntity role, BranchEntity branch, DepartmentEntity department,
			OrganizationEntity organization) {
		super();
		this.userId = userId;
		this.image = image;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.role = role;
		this.branch = branch;
		this.department = department;
		this.organization = organization;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}