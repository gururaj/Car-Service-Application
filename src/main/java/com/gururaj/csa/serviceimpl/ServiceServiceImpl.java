package com.gururaj.csa.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gururaj.csa.entity.Service;
import com.gururaj.csa.exception.ServiceNotFoundByIdException;
import com.gururaj.csa.mapper.CarMapper;
import com.gururaj.csa.mapper.ServiceMapper;
import com.gururaj.csa.repository.ServiceRepository;
import com.gururaj.csa.requestdto.ServiceRequestDto;
import com.gururaj.csa.responsedto.CarResponseDto;
import com.gururaj.csa.responsedto.ServiceResponseDto;
import com.gururaj.csa.service.ServiceService;
import com.gururaj.csa.utility.ResponseStructure;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	public ServiceRepository serviceRepository;

	@Autowired
	public ServiceMapper serviceMapper;

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addServiceById(ServiceRequestDto serviceRequestDto) {

		Service service = serviceMapper.mapToService(serviceRequestDto);

		service = serviceRepository.save(service);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ServiceResponseDto>()
						.setHttpStatusCode(HttpStatus.CREATED.value())
						.setMessage("Service Object FoundSuccessfully!!")
						.setData(serviceMapper.mapToServiceResponseDto(service)));
	}

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateServiceById(int id,ServiceRequestDto serviceRequestDto) {

		Service updatedService = serviceMapper.mapToService(serviceRequestDto);
		return serviceRepository.findById(id)
				.map(service ->{
					updatedService.setId(service.getId());
					serviceRepository.save(updatedService);
					return ResponseEntity
							.status(HttpStatus.OK)
							.body(new ResponseStructure<ServiceResponseDto>()
									.setHttpStatusCode(HttpStatus.OK.value())
									.setMessage("Service Object Updated Successfully!!!")
									.setData(serviceMapper.mapToServiceResponseDto(updatedService)));
				})
				.orElseThrow(()-> new ServiceNotFoundByIdException("Service Not Found!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteServiceById(int id) {
		
		return serviceRepository.findById(id)
				.map(service ->{
					serviceRepository.delete(service);
					return ResponseEntity
							.status(HttpStatus.OK)
							.body(new ResponseStructure<ServiceResponseDto>()
									.setHttpStatusCode(HttpStatus.OK.value())
									.setMessage("Service Object Deleted Successfully!!!")
									.setData(serviceMapper.mapToServiceResponseDto(service))
									);
				})
				.orElseThrow(()-> new ServiceNotFoundByIdException("Service Not Found!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findServiceById(int id) {
		
		return serviceRepository.findById(id)
				.map(service -> 
				ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<ServiceResponseDto>()
						.setHttpStatusCode(HttpStatus.FOUND.value())
						.setMessage("Service Object Found Successfully!!")
						.setData(serviceMapper.mapToServiceResponseDto(service)))
						)
				.orElseThrow(()->new ServiceNotFoundByIdException("Service Object Found Not In The Database"));	
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllServices() {

		List<ServiceResponseDto> serviceResponseDtos =  serviceRepository.findAll()
				.stream()
				.map(service -> serviceMapper.mapToServiceResponseDto(service))
				.toList();
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<ServiceResponseDto>>()
						.setHttpStatusCode(HttpStatus.FOUND.value())
						.setMessage("All Cars Found Successfully!!")
						.setData(serviceResponseDtos));
	}
}
