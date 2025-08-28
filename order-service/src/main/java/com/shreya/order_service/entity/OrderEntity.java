package com.shreya.order_service.entity;

import com.shreya.order_service.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class OrderEntity {
    @Id
    private String orderId;
    private String name;
    private int qty;
    private double price;
    private String userId;

    // constructor to map from DTO
    public OrderEntity(Order dto) {
        this.orderId = dto.getOrderId();
        this.name = dto.getName();
        this.qty = dto.getQty();
        this.price = dto.getPrice();
        this.userId = dto.getUserId();
    }
}

