package com.gururaj.csa.mapper;

import org.springframework.stereotype.Component;

import com.gururaj.csa.entity.Service;
import com.gururaj.csa.requestdto.ServiceRequestDto;
import com.gururaj.csa.responsedto.ServiceResponseDto;

@Component
public class ServiceMapper {
	
	public Service mapToService(ServiceRequestDto serviceRequestDto) {
		
		Service service = new Service();
		service.setType(serviceRequestDto.getType());
		service.setDescription(serviceRequestDto.getDescription());
		service.setCost(serviceRequestDto.getCost());
		
		return service;
		
	}
	
	public ServiceResponseDto mapToServiceResponseDto(Service service) {
		
		ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
		serviceResponseDto.setId(service.getId());
		serviceResponseDto.setType(service.getType());
		serviceResponseDto.setDescription(service.getDescription());
	    serviceResponseDto.setCost(service.getCost());
	    
	    return serviceResponseDto;
	}

}
