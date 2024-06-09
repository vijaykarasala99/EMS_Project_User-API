package com.vijayit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vijayit.dto.UserDTO;
import com.vijayit.entity.UserEntity;

public interface UserService {

	public UserEntity saveUser(MultipartFile image, String firstName, String lastName, String phoneNumber, String email,
			String password, Boolean isActive, Boolean isDeleted, String createdBy, String updatedBy, Integer roleId,
			Integer branchId, Integer departmentId, Integer organizationId) throws IOException;;

	public UserEntity updateUser(Integer userId, MultipartFile image, String firstName, String lastName,
			String phoneNumber, String email, String password, Boolean isActive, Boolean isDeleted, String updatedBy,
			Integer roleId, Integer branchId, Integer departmentId, Integer organizationId) throws IOException;;

	
			
   public UserDTO getUserById(Integer userId);

   public List<UserDTO> getAllUsers();

   public String deleteUserById(Integer userId);

}
