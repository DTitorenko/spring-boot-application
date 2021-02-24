package com.luxoft.springboot.service;

import com.luxoft.springboot.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void add(Order order);
    void addAll(List<Order> orderList);
    void delete(long id);
    Optional<Order> get(long id);
    List<Order> getAll();
}
