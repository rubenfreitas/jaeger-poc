package com.rfreitas.jaegerpoc.controller;

import com.rfreitas.jaegerpoc.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class WeatherController {

  @Autowired private WeatherService weatherService;

  @GetMapping("/hello")
  public String hello() {
    var weather = weatherService.getWeather("UK", "London");
    return "hello " + weather.getTemperature();
  }

}
