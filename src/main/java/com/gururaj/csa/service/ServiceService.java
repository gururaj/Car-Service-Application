package com.gururaj.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gururaj.csa.requestdto.ServiceRequestDto;
import com.gururaj.csa.responsedto.ServiceResponseDto;
import com.gururaj.csa.utility.ResponseStructure;

public interface ServiceService {
	
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addServiceById(ServiceRequestDto serviceRequestDto);

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateServiceById(int id, ServiceRequestDto serviceRequestDto);

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteServiceById(int id);

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findServiceById(int id);

	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllServices();


}
