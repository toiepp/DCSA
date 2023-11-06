package me.mikholsky.practice6.repository;

import me.mikholsky.practice6.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CommonRepository<Order> {
}
