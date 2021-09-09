package com.rw.carapp.controllers;

import com.rw.carapp.services.CarService;
import com.rw.carapp.models.Car;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars-rest/v1")
public class CarController {

  public CarService carService;

  public CarController(CarService carService){
    this.carService = carService;
  }

  @GetMapping("/retrieve/{id}")
  public ResponseEntity<Car> retrieveBy(@PathVariable Integer id)
      throws ResourceNotFoundException
  {
    Car c;
    try {
      c = carService.getSingle(id);
    }
    catch (Exception e){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(c);
  }

  @PostMapping("/cars")
  public ResponseEntity<?> add(@RequestBody Car car){
    try{
      carService.add(car);
      return ResponseEntity.ok().build();
    }
    catch (Exception e){
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/cars/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
    try{
      carService.delete(id);
      return ResponseEntity.ok().build();
    }
    catch (Exception e){
      return ResponseEntity.notFound().build();
    }

  }

}

