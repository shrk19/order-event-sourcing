package com.shreya.order_service.repository;

import com.shreya.order_service.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}
