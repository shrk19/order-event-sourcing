package com.shreya.base_domains.repository;

import com.shreya.base_domains.entity.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderEventRepository extends MongoRepository<OrderEvent, String> {
}
