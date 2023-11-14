package me.mikholsky.practice5.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "telephone")
public class Telephone extends AbstractEntity {
    @Column
    private String manufacturer;

    @Column
    private int volume;

    @Column
    private int distributor;

    @Column
    private String tag;

    @Column
    private BigDecimal price;

    @Column
    private String name;

    public String getManufacturer() {
        return manufacturer;
    }

    public Telephone setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public int getVolume() {
        return volume;
    }

    public Telephone setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public int getDistributor() {
        return distributor;
    }

    public Telephone setDistributor(int distributor) {
        this.distributor = distributor;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Telephone setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Telephone setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public Telephone setName(String name) {
        this.name = name;
        return this;
    }
}
