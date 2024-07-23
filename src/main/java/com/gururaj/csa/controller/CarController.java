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

import com.gururaj.csa.entity.Car;
import com.gururaj.csa.requestdto.CarRequestDto;
import com.gururaj.csa.responsedto.CarResponseDto;
import com.gururaj.csa.service.CarService;
import com.gururaj.csa.utility.ResponseStructure;

@RestController
public class CarController {
	
	@Autowired
	public CarService carService;
	
	@PostMapping("/cars")
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCarById(@RequestBody CarRequestDto carRequestDto){
		return carService.addCarById(carRequestDto);
	}
	
	@PutMapping("/cars/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> updateCarById(@PathVariable int carId, @RequestBody CarRequestDto updatedCarRequestDto){
		return carService.updateCarById(carId,updatedCarRequestDto);
	}
	
	@GetMapping("/cars/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> findCarById(@PathVariable int carId){
		return carService.findCarById(carId);
	}
	
	@DeleteMapping("/cars/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteCarById(@PathVariable int carId){
		return carService.deleteCarById(carId);
	}
	
	@GetMapping("/cars")
	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars(){
		return carService.findAllCars();
	}
	
	

}
