package com.gururaj.csa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gururaj.csa.entity.User;
import com.gururaj.csa.mapper.UserMapper;
import com.gururaj.csa.repository.UserRepository;
import com.gururaj.csa.requestdto.UserRequestDto;
import com.gururaj.csa.responsedto.UserResponseDto;
import com.gururaj.csa.service.UserService;
import com.gururaj.csa.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDto>> registerUser(UserRequestDto userRequestDto) {
		
//		User user = userMapper.mapToUser(userRequestDto);
//		userRepository.save(user);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<UserResponseDto>()
						.setHttpStatusCode(HttpStatus.CREATED.value())
						.setMessage("User Object Created Successfully!!")
						.setData(userMapper.mapToUserResponseDto(userRepository.save(userMapper.mapToUser(userRequestDto)))));
	}

}
