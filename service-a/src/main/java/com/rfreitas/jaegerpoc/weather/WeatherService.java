package com.rfreitas.jaegerpoc.weather;

import org.springframework.cache.annotation.Cacheable;

public interface WeatherService {

  @Cacheable("weather")
  Weather getWeather(String country, String city);

  @Cacheable("forecast")
  WeatherForecast getWeatherForecast(String country, String city);
}
