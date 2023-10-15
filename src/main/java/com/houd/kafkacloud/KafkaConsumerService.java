package com.houd.kafkacloud;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "mon_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // Faites ici le traitement que vous souhaitez effectuer sur le message.
    }
}
