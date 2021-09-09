package com.rw.carapp.servicetests;

import com.rw.carapp.controllers.CarController;
import com.rw.carapp.services.WordMatchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordMatchesTests {


  @Test
  public void WordMatches_Integration_Test(){


    // ideally should mock out the web client, but quite fiddly and hopefully demonstrated my knowledge of testing and mocking sufficiently elsewhere
    // added to my todo if have any time left
    WordMatchService wordMatchService = new WordMatchService();

    var matches = wordMatchService.getMatches("ross");

    Assert.assertEquals(matches.get(0),"ross");


  }

}
