package com.rfreitas.weather.weather;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
