package com.gururaj.csa.service;

import org.springframework.http.ResponseEntity;

import com.gururaj.csa.requestdto.UserRequestDto;
import com.gururaj.csa.responsedto.UserResponseDto;
import com.gururaj.csa.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponseDto>> registerUser(UserRequestDto userRequestDto);

}
