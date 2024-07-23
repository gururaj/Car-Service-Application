package com.gururaj.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gururaj.csa.entity.Car;
import com.gururaj.csa.requestdto.CarRequestDto;
import com.gururaj.csa.responsedto.CarResponseDto;
import com.gururaj.csa.utility.ResponseStructure;


public interface CarService {
	
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCarById(CarRequestDto carRequestDto);

	public ResponseEntity<ResponseStructure<CarResponseDto>> updateCarById(int carId, CarRequestDto updatedCarRequestDto);

	public ResponseEntity<ResponseStructure<CarResponseDto>> findCarById(int carId);

	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteCarById(int carId);

	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars();

}
