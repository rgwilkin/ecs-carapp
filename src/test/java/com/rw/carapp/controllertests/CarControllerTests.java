package com.rw.carapp.controllertests;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.carapp.controllers.CarController;
import com.rw.carapp.models.Car;
import com.rw.carapp.services.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private CarService carService;

  ObjectMapper mapper = new ObjectMapper();

  @Test
  public void test_retrieve() throws Exception {
    Car c = new Car();

    c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    Mockito.when(carService.getSingle(1)).thenReturn(c);

    mvc.perform(get("/cars-rest/v1/retrieve/1")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.make").value(c.getMake()));
  }

  @Test
  public void test_retrieve_exception() throws Exception {
    Car c = new Car();

    c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    Mockito.when(carService.getSingle(1)).thenThrow(Exception.class);

    mvc.perform(get("/cars-rest/v1/retrieve/1")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());


  }

  @Test
  public void test_add() throws Exception {
    Car c = new Car();

    c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);



    mvc.perform(post("/cars-rest/v1/cars")
        .content(mapper.writeValueAsString(c))
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());


    ArgumentCaptor<Car> spitterArgument = ArgumentCaptor.forClass(Car.class);
    Mockito.verify(carService,Mockito.atLeastOnce()).add(spitterArgument.capture());

    Assert.assertEquals(spitterArgument.getValue().getMake(),c.getMake());
  }

  @Test
  public void test_add_exception() throws Exception {
    Car c = new Car();

    c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    doThrow(new Exception()).when(carService).add(any());

    mvc.perform(post("/cars-rest/v1/cars")
        .content(mapper.writeValueAsString(c))
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());


  }

  @Test
  public void test_delete() throws Exception {

    mvc.perform(delete("/cars-rest/v1/cars/1")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    Mockito.verify(carService, Mockito.atLeastOnce()).delete(1);
  }

  @Test
  public void test_delete_exception() throws Exception {

    doThrow(new Exception()).when(carService).delete(1);

    mvc.perform(delete("/cars-rest/v1/cars/1")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());

  }

}
