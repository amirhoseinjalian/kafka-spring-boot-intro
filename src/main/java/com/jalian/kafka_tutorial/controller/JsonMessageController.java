package com.jalian.kafka_tutorial.controller;

import com.jalian.kafka_tutorial.kafka.JsonKafkaProducer;
import com.jalian.kafka_tutorial.kafka.KafkaProducer;
import com.jalian.kafka_tutorial.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/json")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @Value("${spring.kafka.topic.name.json}")
    private String topic;

    @PostMapping("/user")
    public ResponseEntity<String> publish(@RequestBody User message) {
        jsonKafkaProducer.send(message);
        return ResponseEntity.ok("json message published successfully to " + topic);
    }
}
