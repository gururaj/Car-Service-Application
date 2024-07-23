package com.gururaj.csa.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gururaj.csa.entity.Car;
import com.gururaj.csa.exception.CarNotFoundByIdException;
import com.gururaj.csa.mapper.CarMapper;
import com.gururaj.csa.repository.CarRepository;
import com.gururaj.csa.requestdto.CarRequestDto;
import com.gururaj.csa.responsedto.CarResponseDto;
import com.gururaj.csa.service.CarService;
import com.gururaj.csa.utility.ResponseStructure;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	public CarRepository carRepository;

	@Autowired
	public CarMapper carMapper;

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCarById(CarRequestDto carRequestDto) {

		Car car = carMapper.mapToCar(carRequestDto);

		car = carRepository.save(car);	
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<CarResponseDto>()
						.setHttpStatusCode(HttpStatus.CREATED.value())
						.setMessage("Car Object FoundSuccessfully!!")
						.setData(carMapper.mapToCarResponseDto(car)));
	}

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> updateCarById(int carId, CarRequestDto updatedCarRequestDto){
	
		return carRepository.findById(carId)
				.map(car -> {
					Car updatedCar = carMapper.mapToCar(updatedCarRequestDto);
					updatedCar.setId(car.getId());
					carRepository.save(updatedCar);
					return ResponseEntity
							.status(HttpStatus.FOUND)
							.body(new ResponseStructure<CarResponseDto>()
									.setHttpStatusCode(HttpStatus.FOUND.value())
									.setMessage("Car Object FoundSuccessfully!!")
									.setData(carMapper.mapToCarResponseDto(updatedCar)));
				})
				.orElseThrow(() -> new CarNotFoundByIdException("Car Was Not Found In The Database!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> findCarById(int carId) {

		return carRepository.findById(carId)
				.map(car -> 
				ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<CarResponseDto>()
						.setHttpStatusCode(HttpStatus.FOUND.value())
						.setMessage("Car Object FoundSuccessfully!!")
						.setData(carMapper.mapToCarResponseDto(car))))
				.orElseThrow(() -> new CarNotFoundByIdException("Car Was Not Found In The Database!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteCarById(int carId) {

		return carRepository.findById(carId)
				.map(car -> {
					carRepository.delete(car);
					return ResponseEntity
							.status(HttpStatus.FOUND)
							.body(new ResponseStructure<CarResponseDto>()
									.setHttpStatusCode(HttpStatus.FOUND.value())
									.setMessage("Car object Deleted Successfully!!")
									.setData(carMapper.mapToCarResponseDto(car)));

				})
				.orElseThrow(()->new CarNotFoundByIdException("Car Not Found By Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars() {
		
		List<CarResponseDto> carResponseDtos =  carRepository.findAll()
				.stream()
				.map(car -> carMapper.mapToCarResponseDto(car))
				.toList();

		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<CarResponseDto>>()
						.setHttpStatusCode(HttpStatus.FOUND.value())
						.setMessage("All Cars Found Successfully!!")
						.setData(carResponseDtos));
	}
}
