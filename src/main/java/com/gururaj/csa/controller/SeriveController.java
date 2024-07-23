package com.gururaj.csa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gururaj.csa.requestdto.ServiceRequestDto;
import com.gururaj.csa.responsedto.ServiceResponseDto;
import com.gururaj.csa.service.ServiceService;
import com.gururaj.csa.utility.ResponseStructure;

@RestController
public class SeriveController {
	
	@Autowired
	public ServiceService serviceService;
	
	@PostMapping("/services")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addServiceById( ServiceRequestDto serviceRequestDto){
		return serviceService.addServiceById(serviceRequestDto);
	}
	
	@PutMapping("/services/{id}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateServiceById(@PathVariable int id, @RequestBody ServiceRequestDto serviceRequestDto){
		return serviceService.updateServiceById(id,serviceRequestDto);
	}
	
	@DeleteMapping("/services/{id}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteServiceById(@PathVariable int id){
		return serviceService.deleteServiceById(id);
	}
	
	@GetMapping("/services/{id}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findServiceById(@PathVariable int id){
		return serviceService.findServiceById(id);
	}
	
	@GetMapping("/services")
	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllServices(){
		return serviceService.findAllServices();
	}
	



}
