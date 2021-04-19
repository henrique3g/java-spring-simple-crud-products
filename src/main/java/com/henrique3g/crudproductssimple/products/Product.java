package com.henrique3g.crudproductssimple.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    private String description;

    @Positive
    private double price;

    @Deprecated
    Product() {
    }

    public Product(@NotBlank String name, @NotBlank @NotNull String description, @Positive double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(@NotBlank String name, @NotBlank @NotNull String description, @Positive double price, Long id) {
        this(name, description, price);
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public Long getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
