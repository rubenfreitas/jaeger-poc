package com.rfreitas.weather.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Weather {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String temperature;

  public Weather(String temperature) {
    this.temperature = temperature;
  }
}
