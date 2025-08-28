package com.shreya.base_domains.entity;

import com.shreya.base_domains.dto.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_events")
public class OrderEvent {
    @Id
    private String id;
    private String message;
    private OrderStatus status;
    //private Order order;
    private String orderId;
    private LocalDateTime timestamp;
}
