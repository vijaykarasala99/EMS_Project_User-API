package com.vijayit.serviceimpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vijayit.dto.UserDTO;
import com.vijayit.entity.BranchEntity;
import com.vijayit.entity.DepartmentEntity;
import com.vijayit.entity.OrganizationEntity;
import com.vijayit.entity.RoleEntity;
import com.vijayit.entity.UserEntity;
import com.vijayit.repo.BranchRepository;
import com.vijayit.repo.DepartmentRepository;
import com.vijayit.repo.OrganizationRepository;
import com.vijayit.repo.RoleRepository;
import com.vijayit.repo.UserRepository;
import com.vijayit.service.UserService;

@Service
public class UserServiceImple implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public UserEntity saveUser(MultipartFile image, String firstName, String lastName, String phoneNumber, String email,
			String password, Boolean isActive, Boolean isDeleted, String createdBy, String updatedBy, Integer roleId,
			Integer branchId, Integer departmentId, Integer organizationId) {

		UserEntity user = new UserEntity();
		try {
			if (image != null && !image.isEmpty()) {
				user.setImage(image.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		
		//encrypting password
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    user.setPassword(passwordEncoder.encode(password));
	
		user.setIsActive(isActive);
		user.setIsDeleted(isDeleted);
		
		user.setCreatedBy(createdBy);
		user.setUpdatedBy(updatedBy);
		user.setCreatedDate(LocalDateTime.now());
		user.setUpdatedDate(LocalDateTime.now());

        // Set role, branch, department, and organization
		RoleEntity role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
		BranchEntity branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new RuntimeException("Branch not found"));
		DepartmentEntity department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		OrganizationEntity organization = organizationRepository.findById(organizationId)
				.orElseThrow(() -> new RuntimeException("Organization not found"));

		user.setRole(role);
		user.setBranch(branch);
		user.setDepartment(department);
		user.setOrganization(organization);
		return userRepository.save(user);
	}

	
	
	@Override
	public UserEntity updateUser(Integer userId, MultipartFile image, String firstName, String lastName,
			String phoneNumber, String email, String password, Boolean isActive, Boolean isDeleted, String updatedBy,
			Integer roleId, Integer branchId, Integer departmentId, Integer organizationId) {

		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		try {
			if (image != null && !image.isEmpty()) {
				user.setImage(image.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		if (password != null && !password.isEmpty()) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    user.setPassword(passwordEncoder.encode(password));
		
		}
		user.setIsActive(isActive);
		user.setIsDeleted(isDeleted);
		user.setUpdatedBy(updatedBy);
		user.setUpdatedDate(LocalDateTime.now());

		// Set role, branch, department, and organization
		RoleEntity role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
		BranchEntity branch = branchRepository.findById(branchId)
				.orElseThrow(() -> new RuntimeException("Branch not found"));
		DepartmentEntity department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		OrganizationEntity organization = organizationRepository.findById(organizationId)
				.orElseThrow(() -> new RuntimeException("Organization not found"));
		user.setRole(role);
		user.setBranch(branch);
		user.setDepartment(department);
		user.setOrganization(organization);
		return userRepository.save(user);
	}

	
	
	
	
	
	@Override
	public UserDTO getUserById(Integer userId) {
	    UserEntity user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	    return new UserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
	    List<UserEntity> users = userRepository.findAll();
	    return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

	
	@Override
	public String deleteUserById(Integer userId) {
		if (!userRepository.existsById(userId)) {
			throw new RuntimeException("User not found");
		}
		userRepository.deleteById(userId);
		return "User with ID " + userId + " has been deleted successfully.";
	}
}