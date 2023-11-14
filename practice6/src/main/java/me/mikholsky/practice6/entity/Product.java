package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {
    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private double price;

    @Basic(optional = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"products", "cart", "orders"})
    private User user;
}
