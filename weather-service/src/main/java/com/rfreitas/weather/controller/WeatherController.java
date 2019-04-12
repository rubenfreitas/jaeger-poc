package com.rfreitas.weather.controller;

import com.rfreitas.weather.weather.WeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/weather/")
public class WeatherController {

  private final WeatherService weatherService;

  @GetMapping("/current/{country}/{city}")
  public String getCurrentWeather(@PathVariable String country, @PathVariable String city) {
    log.info("getting current weather for country={} city={}", country, city);
    var weather = weatherService.getWeather(country, city);
    return String.valueOf(weather.getTemperature());
  }

}
