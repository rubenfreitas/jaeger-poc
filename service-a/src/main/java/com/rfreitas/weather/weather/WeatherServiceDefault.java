package com.rfreitas.weather.weather;

import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Slf4j
@Service
public class WeatherServiceDefault implements WeatherService {

  private static final String WEATHER_URL = "http://localhost:9001/weather/current/{country}/{city}";

  private final RestTemplate restTemplate;

  public WeatherServiceDefault(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public String getCurrentTemperature(String country, String city) {
    log.info("Requesting current weather for {}/{}", country, city);
    URI url = new UriTemplate(WEATHER_URL).expand(city, country);
    return invoke(url, String.class);
  }

  private <T> T invoke(URI url, Class<T> responseType) {
    RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
    ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
    return exchange.getBody();
  }

}
