package com.rw.carapp.models;
import com.rw.carapp.services.WordMatchService;
import java.util.List;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {



  @Id
  @GeneratedValue
  private  int id;
  private String make;
  private String model;
  private String colour;
  private int year;
  private String similarItems;



  public int getId()
  {
    return id;
  }

  //public void setId(int id){
  //  this.id = id;
  //}

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


  public String getSimilarItems() {
    return similarItems;
  }

  public void setSimilarItems(String similarItems) {
    this.similarItems = similarItems;
  }
}
