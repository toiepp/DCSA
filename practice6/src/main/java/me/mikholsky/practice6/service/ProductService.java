package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService extends AbstractService<Product, ProductRepository> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
