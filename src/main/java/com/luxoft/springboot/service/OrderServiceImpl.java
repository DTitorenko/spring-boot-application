package com.luxoft.springboot.service;

import com.luxoft.springboot.model.Order;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private List<Order> orderStore = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void add(Order order) {
        orderStore.add(order);
    }

    @Override
    public void addAll(List<Order> orderList) {
        orderStore.addAll(orderList);
    }

    @Override
    public void delete(long id) {
        orderStore.removeIf(order -> order.getId() == id);
    }

    @Override
    public Optional<Order> get(long id) {
        return orderStore.stream()
                .filter(order -> order.getId() == id)
                .findAny();
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orderStore);
    }
}
