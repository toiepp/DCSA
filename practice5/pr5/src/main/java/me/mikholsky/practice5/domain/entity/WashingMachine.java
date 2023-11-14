package me.mikholsky.practice5.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "washing_machine")
public class WashingMachine extends AbstractEntity {
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

    public WashingMachine setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public int getVolume() {
        return volume;
    }

    public WashingMachine setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public int getDistributor() {
        return distributor;
    }

    public WashingMachine setDistributor(int distributor) {
        this.distributor = distributor;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public WashingMachine setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public WashingMachine setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public WashingMachine setName(String name) {
        this.name = name;
        return this;
    }
}
