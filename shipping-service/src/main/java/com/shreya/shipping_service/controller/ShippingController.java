package com.shreya.shipping_service.controller;

import com.shreya.base_domains.dto.response.OrderResponse;
import com.shreya.shipping_service.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/ship/{orderId}")
    private ResponseEntity<OrderResponse> shipOrder(@PathVariable String orderId){
        try{
            OrderResponse orderResponse = shippingService.shipOrder(orderId);
            return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deliver/{orderId}")
    public ResponseEntity<OrderResponse> deliverOrder(@PathVariable String orderId) {
        try{
            OrderResponse orderResponse = shippingService.deliverOrder(orderId);
            return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
