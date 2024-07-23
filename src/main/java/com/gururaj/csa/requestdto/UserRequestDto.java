package com.gururaj.csa.requestdto;

import com.gururaj.csa.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
	
	private String name;
	private String email;
	private String password;
	private UserRole userRole;

}
