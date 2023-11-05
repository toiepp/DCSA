package me.mikholsky.practice6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
