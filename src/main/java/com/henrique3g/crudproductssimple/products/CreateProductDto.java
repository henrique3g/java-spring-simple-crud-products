package com.henrique3g.crudproductssimple.products;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CreateProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Positive
    private double price;

    public CreateProductDto(@NotBlank String name, @NotBlank String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product toModel() {
        return new Product(name, description, price);
    }
}
