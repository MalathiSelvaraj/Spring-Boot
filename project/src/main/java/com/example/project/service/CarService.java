package com.example.project.service;

import java.util.List;

import com.example.project.model.Car;

public interface CarService {
	Car saveCar(Car car);
	List<Car> getAllCars();
	Car getCarById(Long id);
	Car updateCarById(Car car,Long id);
	void deleteCarById(Long id);

}
