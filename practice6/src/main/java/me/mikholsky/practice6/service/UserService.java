package me.mikholsky.practice6.service;

import jakarta.transaction.Transactional;
import me.mikholsky.practice6.controller.dto.CartDto;
import me.mikholsky.practice6.controller.dto.CartRowDto;
import me.mikholsky.practice6.controller.dto.OrderDto;
import me.mikholsky.practice6.controller.dto.RegistrationRequestDto;
import me.mikholsky.practice6.entity.*;
import me.mikholsky.practice6.exception.NotEnoughInStorageException;
import me.mikholsky.practice6.repository.OrderRepository;
import me.mikholsky.practice6.repository.ProductRepository;
import me.mikholsky.practice6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService extends AbstractService<User, UserRepository> {
    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Autowired
    public UserService setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        return this;
    }

    @Autowired
    public UserService setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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

        repository.save(user);

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

    public OrderDto findOrderById(Long userId, Long orderId) {
        var user = findById(userId);

        var order = user.getOrders().stream().filter(o -> o.getId().equals(orderId)).findAny().orElse(null);

        if (order == null) {
            throw new IllegalArgumentException("No orders found");
        }
        return OrderDto.from(user, order);
    }


    public OrderDto checkout(Long id) throws NotEnoughInStorageException {
        var user = findById(id);

        var impossible = getListOfImpossibleToCheckout(user.getCart());

        if (impossible.size() != 0) {
            throw new NotEnoughInStorageException("You are can't order more then we have!");
        }

        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setUser(user);

        orderRepository.save(order);

        var orderContent = user.getCart().stream().map(cartRow -> {
            OrderRowId orderId = new OrderRowId();
            orderId.setOrderId(order.getId());
            orderId.setProductId(cartRow.getProduct().getId());

            OrderRow orderRow = new OrderRow();
            orderRow.setId(orderId);
            orderRow.setOrder(order);
            orderRow.setProduct(cartRow.getProduct());
            orderRow.setQuantity(cartRow.getQuantity());

            cartRow.getProduct().setAmount(cartRow.getProduct().getAmount() - cartRow.getQuantity());

            return orderRow;
        }).toList();

        order.setProducts(orderContent);
        user.getOrders().add(order);

        user.clearCart();

        return OrderDto.from(user, order);
    }

    private List<CartRow> getListOfImpossibleToCheckout(List<CartRow> cart) {
        return cart.stream()
                .filter(row -> row.getQuantity() > row.getProduct().getAmount())
                .toList();
    }

    public User register(RegistrationRequestDto requestDto) {
        User user = new User();
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());

        var role = requestDto.getRole();
        if (role == null) {
            role = "ADMIN";
        }

        switch (Role.valueOf(role.toUpperCase())) {
            case SELLER -> user.setRole(Role.SELLER);
            case ADMIN -> user.setRole(Role.ADMIN);
            default -> user.setRole(Role.USER);
        }

        return repository.save(user);
    }

}
