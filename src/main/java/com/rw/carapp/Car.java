package com.rw.carapp;


import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Car {

  @javax.persistence.Id
  @GeneratedValue
  private  Long id;
  private String make;
  private String model;
  private String colour;
  private int year;


  public Long getId()
  {
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getMake()
  {
    return make;
  }

  public void setMake(String make)
  {
    this.make = make;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }


  public String getColour()
  {
    return colour;
  }

  public void setColour(String colour){
    this.colour = colour;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year){
    this.year = year;
  }

}
