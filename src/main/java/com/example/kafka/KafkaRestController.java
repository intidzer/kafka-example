package com.example.kafka;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka-messages")
public class KafkaRestController {

    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${topic.name}")
    String topicName;

    @PostMapping
    public void insertMessage(@RequestBody MessageRequest request) {
        Message message = new Message(request.message(), LocalDate.now());
        kafkaTemplate.send(topicName, message);
    }

}
