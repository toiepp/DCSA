package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductApiController extends AbstractController<Product, ProductService> {
    public ProductApiController(ProductService service) {
        super(service);
    }
}
