package com.rw.carapp.controllertests;


import static reactor.core.publisher.Mono.when;

import com.rw.carapp.controllers.CarController;
import com.rw.carapp.models.Car;
import com.rw.carapp.services.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTests {


@MockBean
  CarService carService;

@Autowired
  MockMvc mockmvc;

@Test
  public void test_should_return_Created_Car(){

    Car car = new Car();
    car.setId(3);
    car.setColour("yellow");
    car.setMake("ferrari");
    car.setModel("f40");
    car.setYear(1985);


    //when(carService.add(any())).thenReturn(car);


}

}
