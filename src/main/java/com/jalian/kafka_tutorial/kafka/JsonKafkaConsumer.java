package com.jalian.kafka_tutorial.kafka;

import com.jalian.kafka_tutorial.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name.json}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        logger.info("Consumed: {}", user);
    }
}
