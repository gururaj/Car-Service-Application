package com.gururaj.csa.responsedto;

import com.gururaj.csa.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
	
	private int id;
	private String name;
	private String email;
	private UserRole userRole; 

}
