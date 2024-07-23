package com.gururaj.csa.requestdto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServiceRequestDto {
	
	private String type;
	private String description;
	private double cost;

}
