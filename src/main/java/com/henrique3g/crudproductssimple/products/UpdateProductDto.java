package com.henrique3g.crudproductssimple.products;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UpdateProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Positive(message = "O preço tem de ser maior que zero")
    private double price;

    public UpdateProductDto(String name, String description, double price) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
    }

    public Product toModel(Product product) {
        return new Product(name, description, price, product.getId());
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
