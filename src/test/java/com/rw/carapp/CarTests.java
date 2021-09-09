package com.rw.carapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.util.Assert.isTrue;

import com.rw.carapp.models.Car;
import com.rw.carapp.services.WordMatchService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CarTests {

  private WordMatchService wordMatchService;
  public CarTests(){
    wordMatchService = new WordMatchService();
  }

  @Test
  public void carTest_IdSetAndGet(){
    Car car = new Car();
    assertEquals(car.getId(),0);
    // check on default initial

    car.setId(99);

    assertEquals(car.getId(),99);
  }

  @Test
  public void carTest_MakeSetAndGet(){
    Car car = new Car();
    assertNull(car.getMake());
    // check on default initial

    car.setMake("Ford");

    assertEquals(car.getMake(),"Ford");
  }

  @Test
  public void carTest_ModelSetAndGet(){
    Car car = new Car();
    assertNull(car.getModel());
    // check on default initial

    car.setModel("Mustang");

    assertEquals(car.getModel(),"Mustang");
  }

  @Test
  public void carTest_colourSetAndGet(){
    Car car = new Car();
    assertNull(car.getColour());
    // check on default initial

    car.setColour("Yellow");

    assertEquals(car.getColour(),"Yellow");
  }

  @Test
  public void carTest_yearSetAndGet(){
    Car car = new Car();
    assertEquals(car.getYear(),0);
    // check on default initial

    car.setYear(1981);

    assertEquals(car.getYear(),1981);
  }

}