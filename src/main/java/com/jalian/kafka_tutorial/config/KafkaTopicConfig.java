package com.jalian.kafka_tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic.name.json}")
    private String jsonTopicName;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName).build();
    }

    @Bean
    public NewTopic JsonTopic() {
        return TopicBuilder.name(jsonTopicName).build();
    }
}
