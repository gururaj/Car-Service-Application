package com.gururaj.csa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gururaj.csa.requestdto.UserRequestDto;
import com.gururaj.csa.responsedto.UserResponseDto;
import com.gururaj.csa.service.UserService;
import com.gururaj.csa.utility.ResponseStructure;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<UserResponseDto>> registerUser(@RequestBody UserRequestDto userRequestDto){
		return userService.registerUser(userRequestDto);	
	} 

}
