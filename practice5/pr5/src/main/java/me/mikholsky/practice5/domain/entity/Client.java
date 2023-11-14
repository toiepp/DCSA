package me.mikholsky.practice5.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {
    @Column(name = "full_name")
    private String fullName;

    @Column
    private String email;

    @Column
    private String password;

    public String getFullName() {
        return fullName;
    }

    public Client setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }
}
