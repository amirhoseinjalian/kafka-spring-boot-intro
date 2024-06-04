package com.jalian.kafka_tutorial.controller;

import com.jalian.kafka_tutorial.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Value("${spring.kafka.topic.name}")
    private String topic;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam(name = "message") String message){
        kafkaProducer.send(message);
        return ResponseEntity.ok(message + " sent to " + topic);
    }
}
