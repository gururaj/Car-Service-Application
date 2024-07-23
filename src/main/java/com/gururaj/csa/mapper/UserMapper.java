package com.gururaj.csa.mapper;


import com.gururaj.csa.entity.User;
import com.gururaj.csa.requestdto.UserRequestDto;
import com.gururaj.csa.responsedto.UserResponseDto;

public class UserMapper {
	
	public User mapToUser(UserRequestDto userRequestDto) {
		
		User user = new User();
		user.setName(userRequestDto.getName());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());
		user.setUserRole(userRequestDto.getUserRole());
		
		return user;
	}
	
	public UserResponseDto mapToUserResponseDto(User user) {
		
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setName(user.getName());
		userResponseDto.setEmail(user.getEmail());
		userResponseDto.setUserRole(user.getUserRole());
		
		return userResponseDto;
		
	}

}
