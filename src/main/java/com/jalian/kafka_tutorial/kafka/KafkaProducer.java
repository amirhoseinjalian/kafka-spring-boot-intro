package com.jalian.kafka_tutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name}")
    public String topicName;

    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void send(String message) {
        kafkaTemplate.send(topicName, message);
        logger.info("Sent message : {}", message);
    }
}
