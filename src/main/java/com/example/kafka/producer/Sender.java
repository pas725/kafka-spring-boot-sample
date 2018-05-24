package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/**
 * Created by psagar on 5/24/2018.
 */
@Service
public class Sender {
    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        LOG.warn("sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
