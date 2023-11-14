package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.controller.dto.CartDto;
import me.mikholsky.practice6.controller.dto.OrderDto;
import me.mikholsky.practice6.controller.dto.ProductDto;
import me.mikholsky.practice6.controller.dto.UserDto;
import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.exception.NotEnoughInStorageException;
import me.mikholsky.practice6.service.UserService;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    @GetMapping("/cart")
    public ResponseEntity<CartDto> getCart() {
        return ResponseEntity.ok(userService.showCart());
    }

    @PostMapping("/cart/{prodId}")
    public ResponseEntity<UserDto> addToCart(@PathVariable Long prodId,
                                             @RequestParam int quantity) {
        return ResponseEntity.ok(UserDto.from(userService.addToCart(prodId, quantity)));
    }

    @DeleteMapping("/cart/{prodId}")
    public ResponseEntity<UserDto> removeFromCart(@PathVariable Long prodId) {
        return ResponseEntity.ok(UserDto.from(userService.addToCart(prodId, 0)));
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrderDto> checkout() {
        OrderDto order;
        try {
            order = userService.checkout();
        } catch (NotEnoughInStorageException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> showOrder(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findOrderById(id));
    }

    @PutMapping("/promote")
    public ResponseEntity<?> requestPromotion() {
        return ResponseEntity.ok(userService.promote());
    }

    /* TODO SELLER
     *   1. Добавлять новые товары на маркетплейс
     *   2. Удалять только свои товары с маркетплейса */

    @GetMapping("/seller/product")
    public ResponseEntity<List<ProductDto>> showSellingProducts() {
        List<ProductDto> dtos = userService.showSellingProducts().stream().map(ProductDto::from).toList();

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/seller/product")
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProductDto.from(userService.addProduct(product)));
    }

    @DeleteMapping("/seller/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        userService.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
