package me.mikholsky.practice6.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CartRowId implements Serializable {
    @Column(name = "user_id")
    @Basic(optional = false)
    private Long userId;

    @Column(name = "product_id")
    @Basic(optional = false)
    private Long productId;
}
