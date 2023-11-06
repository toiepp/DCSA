package me.mikholsky.practice6.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.mikholsky.practice6.controller.dto.CartDto;
import me.mikholsky.practice6.controller.dto.UserDto;
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

    @GetMapping("/{id}/cart")
    @Operation(summary = "Shows content of card of user specified by ID",
            description = "Returns DTO of cart which is just a list of products with few extra properties")
    public ResponseEntity<CartDto> showCart(@PathVariable Long id) {
        var cart = service.showCart(id);

        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{userId}/cart/{prodId}")
    @Operation(summary = "Adds products to user")
    public ResponseEntity<UserDto> addProductToCart(@PathVariable Long userId,
                                                    @PathVariable Long prodId,
                                                    @RequestParam int quantity) {
        var user = service.addToCart(userId, prodId, quantity);

        return ResponseEntity.ok(UserDto.from(user));
    }

    @PutMapping("/{userId}/cart")
    @Operation(summary = "Clears all products added in cart")
    public ResponseEntity<UserDto> clearCart(@PathVariable Long userId) {
        var user = service.clearCart(userId);

        return ResponseEntity.ok(UserDto.from(user));
    }

    @DeleteMapping("/{userId}/cart/product/{prodId}")
    @Operation(summary = "Removes product from cart")
    public ResponseEntity<UserDto> removeFromCart(@PathVariable Long userId,
                                                  @PathVariable Long prodId) {
        var user = service.addToCart(userId, prodId, 0);

        return ResponseEntity.ok(UserDto.from(user));
    }
}
