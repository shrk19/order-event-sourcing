package com.shreya.order_service.service;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
import com.shreya.base_domains.repository.OrderEventRepository;
import com.shreya.base_domains.dto.enums.OrderStatus;
import com.shreya.base_domains.dto.response.OrderResponse;
import com.shreya.base_domains.entity.OrderEvent;
import com.shreya.order_service.dto.Order;
import com.shreya.order_service.entity.OrderEntity;
import com.shreya.order_service.kafka.OrderEventPublisher;
import com.shreya.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderEventRepository orderEventRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventPublisher publisher;

    // Order Creation
    public OrderResponse placeOrder(Order order){

        String orderId = UUID.randomUUID().toString();
        order.setOrderId(orderId);
        String eventId = UUID.randomUUID().toString();

        OrderEvent orderEvent = new OrderEvent(
                eventId,
                "Order has been placed.",
                OrderStatus.CONFIRMED,
                orderId,
                LocalDateTime.now()
        );

        saveOrderToDb(new OrderEntity(order));
        saveAndPublishEvent(orderEvent);
        return new OrderResponse(orderId, OrderStatus.CONFIRMED);
    }

    private void saveOrderToDb(OrderEntity order) {
        orderRepository.save(order);
    }

    private void saveAndPublishEvent(OrderEvent orderEvent) {
        try {
            orderEventRepository.save(orderEvent);
            System.out.println("Saved to db");
            publisher.publishOrderEvent(orderEvent);
            System.out.println("Saved to topic");
        }catch (Exception e){
            e.printStackTrace();
        }

//        String uri = "mongodb+srv://<username>:<password>@cluster0.****.mongodb.net/<dbname>";
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase db = mongoClient.getDatabase("<dbname>");
//            db.getCollection("order_events").insertOne(new Document("test", "connection successful"));
//            System.out.println("Inserted test document successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
