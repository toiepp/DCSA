package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        return this;
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
