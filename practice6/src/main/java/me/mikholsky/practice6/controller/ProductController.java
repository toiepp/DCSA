package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product", produces = "application/json")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController setProductService(ProductService productService) {
        this.productService = productService;
        return this;
    }

    @GetMapping({"", "/"})
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping({"", "/"})
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
}
