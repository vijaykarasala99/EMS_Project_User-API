package com.vijayit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vijayit.dto.UserDTO;
import com.vijayit.entity.UserEntity;
import com.vijayit.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserEntity> saveUser(@RequestParam(required = false) MultipartFile image,
			@RequestParam String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String phoneNumber,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) Boolean isActive, 
			@RequestParam(required = false) Boolean isDeleted,
			@RequestParam(required = false) String createdBy, 
			@RequestParam(required = false) String updatedBy,
			@RequestParam Integer roleId,
			@RequestParam Integer branchId,
			@RequestParam Integer departmentId, 
			@RequestParam Integer organizationId) {
		    UserEntity savedUser = userService.saveUser(image, firstName, lastName, phoneNumber, email, 
		    password, isActive,isDeleted, createdBy, updatedBy, roleId, branchId, departmentId, organizationId);
		return ResponseEntity.ok(savedUser);
	}

	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Integer userId,
			@RequestParam(required = false) MultipartFile image,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String phoneNumber,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) Boolean isActive, 
			@RequestParam(required = false) Boolean isDeleted,
			@RequestParam(required = false) String createdBy, 
			@RequestParam(required = false) String updatedBy,
			@RequestParam Integer roleId,
			@RequestParam Integer branchId,
			@RequestParam Integer departmentId, 
			@RequestParam Integer organizationId) {
		    
		    UserEntity updatedUser = userService.updateUser(userId, image, firstName, lastName, phoneNumber, email,
		    password, isActive, isDeleted, updatedBy, roleId, branchId, departmentId, organizationId);  
		    return ResponseEntity.ok(updatedUser);
	}

	
	
	
	
	
	
	 @GetMapping("/get/{userId}")
	    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
	        UserDTO user = userService.getUserById(userId);
	        return ResponseEntity.ok(user);
	    }

	    @GetMapping("/getall")
	    public ResponseEntity<List<UserDTO>> getAllUsers() {
	        List<UserDTO> users = userService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		String response = userService.deleteUserById(userId);
		return ResponseEntity.ok(response);
	}

}