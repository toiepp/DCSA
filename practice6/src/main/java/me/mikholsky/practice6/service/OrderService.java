package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.Order;
import me.mikholsky.practice6.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService extends AbstractService<Order, OrderRepository> {
    public OrderService(OrderRepository repository) {
        super(repository);
    }
}
