package com.rfreitas.weather.controller;

import com.rfreitas.weather.weather.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/someapi/")
public class WeatherController {

  private final WeatherService weatherService;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/random/temps")
  public String hello() {
    var weather = weatherService.getCurrentTemperature("UK", "London");
    kafkaTemplate.send("test", weather);
    return "temperature=" + weather;
  }

}
