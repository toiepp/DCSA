package me.mikholsky.practice6.repository;

import me.mikholsky.practice6.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CommonRepository<Product> {
}
