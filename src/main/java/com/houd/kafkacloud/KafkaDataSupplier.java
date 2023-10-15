package com.houd.kafkacloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class KafkaDataSupplier {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000) // Exemple de génération de données toutes les 5 secondes
    public void generateData() {
        String message = "Nouvelle donnée générée : " + new Date();
        kafkaTemplate.send("mon_topic", message);
    }
}
