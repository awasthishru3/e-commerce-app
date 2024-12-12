package com.e_commerce.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.userdetails.dto.UserDTO;
import com.e_commerce.userdetails.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserDTO> saveUserDetails(@RequestBody UserDTO userDto){
		UserDTO savedUserDetails = userService.saveUserDetails(userDto);
		return new ResponseEntity<UserDTO>(savedUserDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserDetail/{userId}")
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable("userId") Long userId){
		UserDTO userDetail = userService.getUserDetailsById(userId);
		return new ResponseEntity<UserDTO>(userDetail, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUserDetails")
	public ResponseEntity<List<UserDTO>> getAllUserDetails(){
		List<UserDTO> userDetails = userService.getAllUserDetails();
		return new ResponseEntity<List<UserDTO>>(userDetails, HttpStatus.OK);
	}
	
	@PutMapping("/updateUserDetail")
	public ResponseEntity<String> updateUserDetail(@RequestBody UserDTO user){
		Boolean userStatus = userService.updateUserDetails(user);
		String message = userStatus ? "User Details Updated successfully" : "User Details have not been saved.. !!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserDetail/{userId}")
	public ResponseEntity<String> deleteUserDetail(@PathVariable("userId") Long userId){
		Boolean userStatus = userService.deleteUserDetail(userId);
		String message = userStatus ? "User Details deleted successfully" : "User Details have not been deleted.. !!";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
