package com.shreya.order_service.controller;

import com.shreya.order_service.dto.Order;
import com.shreya.base_domains.dto.response.OrderResponse;
import com.shreya.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    private ResponseEntity<OrderResponse> placeOrder(@RequestBody Order order){
        try{
            OrderResponse orderResponse = orderService.placeOrder(order);
            return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
