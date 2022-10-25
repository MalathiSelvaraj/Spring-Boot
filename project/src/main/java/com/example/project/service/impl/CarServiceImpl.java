package com.example.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Car;
import com.example.project.repository.CarRepo;
import com.example.project.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	private CarRepo carrepo;
	

	public CarServiceImpl(CarRepo carrepo) {
		super();
		this.carrepo = carrepo;
	}


	@Override
	public Car saveCar(Car car) {
		return carrepo.save(car);
	}


	@Override
	public List<Car> getAllCars() {
		return carrepo.findAll();
	}


	@Override
	public Car getCarById(Long id) {
		Optional<Car> car=carrepo.findById(id);
		if(car.isPresent()) {
			return car.get();
		}else {
			throw new ResourceNotFoundException("car","id",id);
		}
	}


	@Override
	public Car updateCarById(Car car, Long id) {
		Car existingCar=carrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("car","id",id));
		existingCar.setCarModel(car.getCarModel());
		existingCar.setCarNo(car.getCarNo());
		existingCar.setStatus(car.getStatus());
		carrepo.save(existingCar);
		return existingCar;
	}


	@Override
	public void deleteCarById(Long id) {
		carrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("car","id",id));
		carrepo.deleteById(id);
		
	}

}

