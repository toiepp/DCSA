package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController<Product, ProductService> {
    public ProductController(ProductService service) {
        super(service);
    }
}
