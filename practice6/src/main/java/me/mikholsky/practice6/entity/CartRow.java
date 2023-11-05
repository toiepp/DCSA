package me.mikholsky.practice6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Cart")
@Table(name = "user_products")
@Data
public class CartRow {
    @EmbeddedId
    private CartRowId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
}
