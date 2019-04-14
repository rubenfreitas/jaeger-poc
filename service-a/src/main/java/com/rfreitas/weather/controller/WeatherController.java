package com.rfreitas.weather.controller;

import com.rfreitas.weather.weather.Weather;
import com.rfreitas.weather.weather.WeatherRepository;
import com.rfreitas.weather.weather.WeatherService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/")
public class WeatherController {

  private final WeatherService weatherService;
  private final WeatherRepository weatherRepository;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping("/random/temps")
  public String getCurrentTemperature() {
    var weather = weatherService.getCurrentTemperature("UK", "London");
    kafkaTemplate.send("test", weather);
    weatherRepository.save(new Weather(weather));
    return "temperature=" + weather;
  }

}
