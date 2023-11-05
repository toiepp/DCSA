package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {
    @Basic(optional = false)
    private String name;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CartRow> cart = new ArrayList<>();

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
}
