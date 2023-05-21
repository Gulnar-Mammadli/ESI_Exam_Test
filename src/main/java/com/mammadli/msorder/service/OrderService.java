package com.mammadli.msorder.service;

import com.mammadli.msorder.dto.OrderDto;
import com.mammadli.msorder.model.Order;
import com.mammadli.msorder.model.OrderStatus;
import com.mammadli.msorder.model.PaymentStatus;
import com.mammadli.msorder.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .productId(orderDto.getProductId())
                .userId(orderDto.getUserId())
                .price(orderDto.getPrice())
                .deliveryAddress(orderDto.getDeliveryAddress())
                .orderStatus(OrderStatus.CREATED)
                .paymentStatus(PaymentStatus.PENDING)
                .build();

        orderDto.setOrderStatus(OrderStatus.CREATED);
        orderDto.setPaymentStatus(PaymentStatus.PENDING);

       return orderRepository.save(order);
    }
}
