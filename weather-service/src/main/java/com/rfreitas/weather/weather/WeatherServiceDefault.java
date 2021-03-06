package com.rfreitas.weather.weather;

import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Slf4j
@Service
public class WeatherServiceDefault implements WeatherService {

  private static final String WEATHER_URL =
      "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}&units=metric";

  private static final String FORECAST_URL =
      "http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}&units=metric";

  private final RestTemplate restTemplate;

  private final String apiKey;

  public WeatherServiceDefault(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
    apiKey = "996a5b31833bbb7d287fbc905c9b1e10";
  }

  @Override
  @Cacheable("weather")
  public Weather getWeather(String country, String city) {
    log.info("Requesting current weather for {}/{}", country, city);
    URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
    return invoke(url, Weather.class);
  }

  @Override
  @Cacheable("forecast")
  public WeatherForecast getWeatherForecast(String country, String city) {
    log.info("Requesting weather forecast for {}/{}", country, city);
    URI url = new UriTemplate(FORECAST_URL).expand(city, country, this.apiKey);
    return invoke(url, WeatherForecast.class);
  }

  private <T> T invoke(URI url, Class<T> responseType) {
    RequestEntity<?> request = RequestEntity.get(url)
        .accept(MediaType.APPLICATION_JSON).build();
    ResponseEntity<T> exchange = this.restTemplate
        .exchange(request, responseType);
    return exchange.getBody();
  }

}
