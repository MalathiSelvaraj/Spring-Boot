package com.example.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Car;
import com.example.project.service.CarService;

@RestController// internally contain @controller and @responsebody->will convert json to java object
@RequestMapping
public class ProjectController {

public CarService carservice;

public ProjectController(CarService carservice) {
	super();
	this.carservice = carservice;
}

@PostMapping("/saveCar")
public ResponseEntity<Car> savecar(@RequestBody Car car){
	return new ResponseEntity<Car>(carservice.saveCar(car),HttpStatus.CREATED);
}

@GetMapping("/getCars")
public List<Car> getAllCars(){
	return carservice.getAllCars();
}

@GetMapping("/getCar/{id}")
public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
	return new ResponseEntity<Car>(carservice.getCarById(id),HttpStatus.OK);
}

@PutMapping("/editCar/{id}")
public ResponseEntity<Car> updateCar(@PathVariable("id") long id,@RequestBody Car car){
	return new ResponseEntity<Car>(carservice.updateCarById(car,id), HttpStatus.OK);
	
}

@DeleteMapping("/deleteCar/{id}")
public  ResponseEntity<String> deleteCar(@PathVariable("id") long id){
	carservice.deleteCarById(id);
	return new ResponseEntity<String>("Car Deleted Successfully",HttpStatus.OK);
}
}
 