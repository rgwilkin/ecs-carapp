package com.rw.carapp.services;

import com.rw.carapp.models.Car;
import com.rw.carapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarService {

  CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository){
    this.carRepository = carRepository;
  }

  public void add(Car car) throws Exception {
    carRepository.save(car);
  }

  public void delete(int id) throws Exception{
    carRepository.deleteById(id);
  }

  public Car getSingle(int id) throws Exception {
    Car c = carRepository.findById(id).get();

    return c;
  }
}
