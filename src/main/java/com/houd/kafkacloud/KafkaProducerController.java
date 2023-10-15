package com.houd.kafkacloud;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish/{message}")
    public String sendMessageToKafkaTopic(@PathVariable String message) {
        kafkaTemplate.send("testTopic", message);
        return "Message envoyé au topic Kafka avec succès : " + message;
    }
}
