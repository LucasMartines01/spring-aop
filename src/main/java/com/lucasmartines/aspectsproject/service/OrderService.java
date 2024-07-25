package com.lucasmartines.aspectsproject.service;

import com.lucasmartines.aspectsproject.entity.Order;
import com.lucasmartines.aspectsproject.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OrderService {
    Map<Long, Order> orders = new LinkedHashMap<>();


    public void createOrder(Order order) {
        try {
            Thread.sleep(100);
            if (order.id() == 4) {
                throw new BusinessException("Order id 4 is not allowed");
            }
            orders.put(order.id(), order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
