package com.rw.carapp.services;

import com.rw.carapp.models.Car;
import com.rw.carapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  CarRepository carRepository;
  WordMatchService wordMatchService;

  @Autowired
  public CarService(@Autowired CarRepository carRepository, @Autowired WordMatchService wordMatchService)
  {
    this.carRepository = carRepository;
    this.wordMatchService = wordMatchService;
  }

  public Car add(Car car) throws Exception {
    // add similar items for model
    return addOrUpdate(car);
  }

  public Car update(Car car) throws Exception{

    return addOrUpdate(car);

  }

  private Car addOrUpdate(Car car) throws Exception{


    String similarItems = String.join(",", wordMatchService.getMatches(car.getModel()));

    car.setSimilarItems(similarItems);
    return carRepository.save(car);

  }

  public void delete(int id) throws Exception{
    carRepository.deleteById(id);
  }

  public Car getSingle(int id) throws Exception {
    Car c = carRepository.findById(id).get();

    return c;
  }
}
