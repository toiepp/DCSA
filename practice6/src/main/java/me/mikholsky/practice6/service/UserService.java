package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.entity.CartRow;
import me.mikholsky.practice6.entity.User;
import me.mikholsky.practice6.repository.ProductRepository;
import me.mikholsky.practice6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User addToCart(Long userId, Long productId, int quantity) {
        var user = findById(userId);

        var product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("No such product with id " + productId));

        if (product.getAmount() < quantity) {
            throw new IllegalArgumentException("There are only " + product.getAmount() + " of requested product left in storage");
        }

        user.addToCart(product, quantity);

        return user;
    }
}
