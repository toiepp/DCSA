package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Cart")
@Table(name = "user_products")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CartRow {
    @EmbeddedId
    private CartRowId id;

    @JsonIgnore
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
