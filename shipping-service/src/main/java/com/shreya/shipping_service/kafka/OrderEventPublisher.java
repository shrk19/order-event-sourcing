package com.shreya.shipping_service.kafka;

import com.shreya.base_domains.entity.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public void publishOrderEvent(OrderEvent orderEvent){
        kafkaTemplate.send(topicName, orderEvent);
    }

}
