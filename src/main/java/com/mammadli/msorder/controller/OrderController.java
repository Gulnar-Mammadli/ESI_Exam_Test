package com.mammadli.msorder.controller;

import com.mammadli.msorder.dto.OrderDto;
import com.mammadli.msorder.model.Order;
import com.mammadli.msorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    Order createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}
