package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.controller.dto.CartDto;
import me.mikholsky.practice6.controller.dto.CartRowDto;
import me.mikholsky.practice6.entity.Product;
import me.mikholsky.practice6.entity.User;
import me.mikholsky.practice6.repository.ProductRepository;
import me.mikholsky.practice6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService extends AbstractService<User, UserRepository> {
    private ProductRepository productRepository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Autowired
    public UserService setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        return this;
    }

    public CartDto showCart(Long id) {
        var user = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("No such user with ID %d", id)));

        return CartDto.from(user.getCart().stream().map(CartRowDto::from).toList());
    }

    public User addToCart(Long userId, Long productId, int quantity) {
        var user = findById(userId);

        var product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("No such product with id " + productId));

        if (product.getAmount() < quantity) {
            throw new IllegalArgumentException("There are only " + product.getAmount() + " of requested product left in storage");
        }

        if (quantity == 0) {
           removeFromCart(user, product);
        } else {
            user.addToCart(product, quantity);
        }

        return user;
    }

    public void removeFromCart(User user, Product product) {
        user.removeFromCart(product);
    }

    public User clearCart(Long userId) {
        var user = repository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("No such user with ID %d", userId)));

        user.clearCart();

        return user;
    }
}
