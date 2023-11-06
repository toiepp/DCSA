package me.mikholsky.practice6.controller;

import me.mikholsky.practice6.entity.User;
import me.mikholsky.practice6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {
    public UserController(UserService service) {
        super(service);
    }

    @PostMapping("/{userId}/cart/{prodId}")
    public ResponseEntity<User> addProductToCart(@PathVariable Long userId,
                                                 @PathVariable Long prodId,
                                                 @RequestParam int quantity) {
        var user = service.addToCart(userId, prodId, quantity);

        return ResponseEntity.ok(user);
    }
}
