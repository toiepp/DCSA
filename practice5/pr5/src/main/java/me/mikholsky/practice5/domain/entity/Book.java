package me.mikholsky.practice5.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book extends AbstractEntity {
    @Column
    private String author;

    @Column
    private int distributor;

    @Column
    private String tag;

    @Column
    private BigDecimal price;

    @Column
    private String name;

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getDistributor() {
        return distributor;
    }

    public Book setDistributor(int distributor) {
        this.distributor = distributor;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Book setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Book setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }
}
