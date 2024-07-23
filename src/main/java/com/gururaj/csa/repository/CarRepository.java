package com.gururaj.csa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gururaj.csa.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}
