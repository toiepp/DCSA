package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"cart", "orders"})
public class User extends AbstractEntity {
    @Basic(optional = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<CartRow> cart = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        var productInCart = cart.stream()
                .filter(cartRow -> cartRow.getProduct().equals(product))
                .findAny()
                .orElseGet(() -> {
                    var res = new CartRow();

                    CartRowId cartRowId = new CartRowId();
                    cartRowId.setUserId(User.this.getId());
                    cartRowId.setProductId(product.getId());

                    res.setId(cartRowId);
                    res.setUser(User.this);
                    res.setProduct(product);
                    res.setQuantity(quantity);

                    return res;
                });

        productInCart.setQuantity(quantity);


        cart.add(productInCart);
    }

    public void removeFromCart(Product product) {
        cart.removeIf(row -> row.getProduct().equals(product));
    }

    public void clearCart() {
        this.cart.clear();
    }
}
