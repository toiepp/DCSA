package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.Order;
import me.mikholsky.practice6.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        return this;
    }

    public Iterable<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        return this.orderRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Order save(Order order) {
        return this.orderRepository.save(order);
    }
}
