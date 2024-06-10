package com.vijayit.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	private static final String UPLOAD_DIR = "uploads/";

	@PostMapping("/save")
	public ResponseEntity<UserEntity> createUser(@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam("firstName") String firstName,

			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "isActive", required = false) Boolean isActive,
			@RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value = "updatedBy", required = false) String createdBy,
			@RequestParam(value = "updatedBy", required = false) String updatedBy,

			@RequestParam("roleId") Integer roleId, @RequestParam("branchId") Integer branchId,
			@RequestParam("departmentId") Integer departmentId, @RequestParam("organizationId") Integer organizationId)
			throws IOException {

		UserEntity user = userService.saveUser(image, firstName, lastName, phoneNumber, email, password, isActive,
		isDeleted, createdBy, updatedBy, roleId, branchId, departmentId, organizationId);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Integer userId,

			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam("firstName") String firstName,

			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "isActive", required = false) Boolean isActive,
			@RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value = "updatedBy", required = false) String updatedBy,

			@RequestParam(value = "roleId", required = false) Integer roleId,
			@RequestParam(value = "branchId", required = false) Integer branchId,
			@RequestParam(value = "departmentId", required = false) Integer departmentId,
			@RequestParam(value = "organizationId", required = false) Integer organizationId) throws IOException {

		UserEntity user = userService.updateUser(userId, image, firstName, lastName, phoneNumber, email, password,
				isActive, isDeleted, updatedBy, roleId, branchId, departmentId, organizationId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
	
	
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
		UserDTO user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		String result = userService.deleteUserById(userId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/image/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		try {
			Path file = Paths.get(UPLOAD_DIR).resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + resource.getFilename() + "\"")
						.contentType(MediaType.IMAGE_JPEG).body(resource);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}