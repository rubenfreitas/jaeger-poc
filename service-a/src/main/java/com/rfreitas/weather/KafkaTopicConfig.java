package com.rfreitas.weather;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = ofEntries(
        entry(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
    );
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic topicTest() {
    return new NewTopic("test", 1, (short) 1);
  }

}
