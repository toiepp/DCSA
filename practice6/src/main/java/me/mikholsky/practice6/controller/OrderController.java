package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.Order;
import me.mikholsky.practice6.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends AbstractController<Order, OrderService> {
    public OrderController(OrderService service) {
        super(service);
    }
}
