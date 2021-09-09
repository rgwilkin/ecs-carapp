package com.rw.carapp.servicetests;

import com.rw.carapp.models.Car;
import com.rw.carapp.repositories.CarRepository;
import com.rw.carapp.services.CarService;
import com.rw.carapp.services.WordMatchService;
import com.sun.source.tree.ModuleTree.ModuleKind;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;


@RunWith(MockitoJUnitRunner.class)
public class CarServiceTests {


  @Mock
  CarRepository carRepository;

  @Mock
  WordMatchService wordMatchService;

  @InjectMocks
  CarService carService;

  // implement here
  @Test
  public void add_test() throws Exception{
    Car c = new Car();

    //c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    carService.add(c);

    ArgumentCaptor<String> spitterArgument = ArgumentCaptor.forClass(String.class);
    Mockito.verify(wordMatchService,Mockito.atLeastOnce()).getMatches(spitterArgument.capture());

    Assert.assertEquals(spitterArgument.getValue(),c.getModel());

    Mockito.verify(carRepository, Mockito.atLeastOnce()).save(c);
  }

  @Test
  public void delete_test() throws Exception{
    carService.delete(22);
    Mockito.verify(carRepository,Mockito.atLeastOnce()).deleteById(22);
  }

  @Test
  public void get_test() throws Exception{
    Car c = new Car();

    //c.setId(1);
    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    Mockito.when(carRepository.findById(2)).thenReturn(java.util.Optional.of(c));

    Assert.assertEquals(carService.getSingle(2),c);
  }

  @Test
  public void update_test() throws Exception{
    Car c = new Car();

    c.setMake("ford");
    c.setModel("focus");
    c.setColour("black");
    c.setYear(2000);

    carService.update(c);

    ArgumentCaptor<String> spitterArgument = ArgumentCaptor.forClass(String.class);
    Mockito.verify(wordMatchService,Mockito.atLeastOnce()).getMatches(spitterArgument.capture());

    Assert.assertEquals(spitterArgument.getValue(),c.getModel());

    Mockito.verify(carRepository, Mockito.atLeastOnce()).save(c);
  }
}
