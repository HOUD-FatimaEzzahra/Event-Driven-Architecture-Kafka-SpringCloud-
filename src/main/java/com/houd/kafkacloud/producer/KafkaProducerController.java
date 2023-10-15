package com.houd.kafkacloud.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/produce/{topic}")
    public String produceMessage(@PathVariable String topic, @RequestBody String message) {
        kafkaTemplate.send(topic, message);
        return "Message sent successfully to topic " + topic;
    }
}
