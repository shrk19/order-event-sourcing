package com.shreya.email_service.service;

import com.shreya.base_domains.entity.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    private void orderConsumer(OrderEvent orderEvent){
        // send email to customer
        log.info("Order id : {}, State : {}", orderEvent.getOrderId(), orderEvent.getStatus());
    }
}
