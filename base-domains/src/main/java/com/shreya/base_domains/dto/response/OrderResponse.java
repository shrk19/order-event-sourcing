package com.shreya.base_domains.dto.response;

import com.shreya.base_domains.dto.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderId;
    private OrderStatus status;
}
