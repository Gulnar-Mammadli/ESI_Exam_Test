package com.mammadli.mspayment.service;

import com.mammadli.mspayment.dto.OrderDto;
import com.mammadli.mspayment.dto.OrderStatus;
import com.mammadli.mspayment.dto.PaymentStatus;
import com.mammadli.mspayment.model.UserBalance;
import com.mammadli.mspayment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void makePayment(OrderDto orderDto){
        Optional<UserBalance> userBalance = paymentRepository.findById(orderDto.getOrderId());
        if(userBalance.isPresent()){

            if (userBalance.get().getBalance().compareTo(orderDto.getPrice()) == 1) {
                userBalance.get().setBalance(userBalance.get().getBalance().subtract(orderDto.getPrice()));
                paymentRepository.save(userBalance.get());

                orderDto.setPaymentStatus(PaymentStatus.COMPLETED);
                orderDto.setOrderStatus(OrderStatus.COMPLETED);

//                kafkaTemplate.send("paymentTopic", orderDto);

            } else {

                orderDto.setPaymentStatus(PaymentStatus.FAILED);
                orderDto.setOrderStatus(OrderStatus.CANCELLED);

//                kafkaTemplate.send("paymentTopic", orderDto);
            }

        }
    }

}
