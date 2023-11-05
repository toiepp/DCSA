package me.mikholsky.practice6.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "pk.order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public BigDecimal getTotalPrice() {
        BigDecimal bd = new BigDecimal("0");
        List<OrderProduct> orderProductList = getOrderProducts();
        for (var op : orderProductList) {
            bd = bd.add(op.getTotalPrice());
        }

        return bd;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
}
