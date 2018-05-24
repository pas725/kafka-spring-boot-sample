package com.example.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by psagar on 5/24/2018.
 */
@Service
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${kafka.topic.demo}")
    public void listen(@Payload String message) {
        LOG.error("received message='{}'", message);
    }
}
