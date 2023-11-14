package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"cart", "orders", "products"})
public class User extends AbstractEntity implements UserDetails {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Product> products = new ArrayList<>();

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
                .filter(cartRow -> cartRow.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElseGet(() -> {
                    var res = new CartRow();

                    CartRowId cartRowId = new CartRowId();
                    cartRowId.setUserId(User.this.getId());
                    cartRowId.setProductId(product.getId());

                    res.setId(cartRowId);
                    res.setUser(User.this);
                    res.setProduct(product);
                    res.setQuantity(0);

                    return res;
                });

        var amountInCart = productInCart.getQuantity();

        if (amountInCart == 0) {
            productInCart.setQuantity(quantity);
            cart.add(productInCart);
        } else {
            productInCart.setQuantity(quantity);
            this.cart.stream()
                    .filter(r -> r.getProduct().getId().equals(productInCart.getProduct().getId()))
                    .findFirst()
                    .get()
                    .setQuantity(amountInCart + quantity);
        }
    }

    public void removeFromCart(Product product) {
        cart.removeIf(row -> row.getProduct().equals(product));
    }

    public void clearCart() {
        this.cart.clear();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
