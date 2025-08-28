package com.shreya.shipping_service.service;

import com.shreya.base_domains.dto.enums.OrderStatus;
import com.shreya.base_domains.dto.response.OrderResponse;
import com.shreya.base_domains.entity.OrderEvent;
import com.shreya.base_domains.repository.OrderEventRepository;
import com.shreya.shipping_service.kafka.OrderEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ShippingService {

    @Autowired
    private OrderEventRepository repository;

    @Autowired
    private OrderEventPublisher publisher;

    public OrderResponse shipOrder(String orderId){
        String message = "Order shipped successfully.";
        OrderStatus orderStatus = OrderStatus.SHIPPED;
        OrderEvent orderEvent = createOrderEvent(orderId, message, orderStatus);
        saveAndPublishEvent(orderEvent);
        return new OrderResponse(orderId, orderStatus);
    }

    public OrderResponse deliverOrder(String orderId){
        String message = "Order delivered successfuly";
        OrderStatus orderStatus = OrderStatus.DELIVERED;
        OrderEvent orderEvent = createOrderEvent(orderId, message, orderStatus);
        saveAndPublishEvent(orderEvent);
        return new OrderResponse(orderId, orderStatus);
    }

    private OrderEvent createOrderEvent(String orderId, String message, OrderStatus orderStatus){
        String eventId = UUID.randomUUID().toString();
        return new OrderEvent(
                eventId,
                message,
                orderStatus,
                orderId,
                LocalDateTime.now()
        );
    }

    private void saveAndPublishEvent(OrderEvent orderEvent) {
        try {
            repository.save(orderEvent);
            publisher.publishOrderEvent(orderEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
