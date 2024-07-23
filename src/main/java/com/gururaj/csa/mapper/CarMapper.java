package com.gururaj.csa.mapper;

import org.springframework.stereotype.Component;

import com.gururaj.csa.entity.Car;
import com.gururaj.csa.requestdto.CarRequestDto;
import com.gururaj.csa.responsedto.CarResponseDto;

@Component
public class CarMapper {
	
	public Car mapToCar(CarRequestDto request) {
		
		Car car = new Car();
		car.setBrand(request.getBrand());
		car.setModel(request.getModel());
		
		return car;
		
	}
	
	public CarResponseDto mapToCarResponseDto(Car car) {
		
		CarResponseDto carResponseDto = new CarResponseDto();
		carResponseDto.setId(car.getId());
		carResponseDto.setBrand(car.getBrand());
		carResponseDto.setModel(car.getModel());
		
		return carResponseDto;
	}

}
