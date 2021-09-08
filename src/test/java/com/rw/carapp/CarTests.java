package com.rw.carapp;

import static org.springframework.util.Assert.isTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarTests {

  @Test
  public void carTest_IdSetAndGet(){
    Car car = new Car();
    assertEquals(car.getId(),null);
    // check on default initial

    car.setId(99l);

    assertEquals(car.getId(),99l);
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