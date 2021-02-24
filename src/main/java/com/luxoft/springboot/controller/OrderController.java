package com.luxoft.springboot.controller;

import com.luxoft.springboot.model.Order;
import com.luxoft.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addOrder(@RequestBody Order order) {
        orderService.add(order);
    }

    @PutMapping("/order")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAll(@RequestBody List<Order> orderList) {
        orderService.addAll(orderList);
    }

    @DeleteMapping("/order/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        orderService.delete(id);
    }

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Order> get(@PathVariable("id") long id) {
        return orderService.get(id);
    }

    @GetMapping("/order/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping(value = "/order/upload", consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void uploadXML(@RequestBody Order order) {
        orderService.add(order);
    }

    @PostMapping(value = "/order/upload", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> uploadAnyFormat() {
        return ResponseEntity.badRequest().body("Wrong format. XML should be used.");
    }
}
