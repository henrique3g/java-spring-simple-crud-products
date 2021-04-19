package com.henrique3g.crudproductssimple.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProductsControllerTest {
    @Autowired
    private ProductsController productsController;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getAll() {
        List<Product> products = productsController.getAllProducts();
        assertEquals(0, products.size(), "Should initiate with 0 products");
    }

    @Test
    @Transactional
    public void getOneProduct() {
        Product newProduct = productRepository.save(new Product("Produto 1", "Descrição 1", 3.5));
        assertEquals(HttpStatus.NOT_FOUND, productsController.getProductDetail(12l).getStatusCode(),
                "Should return not found when finded not existed product");
        ResponseEntity<Product> response = productsController.getProductDetail(newProduct.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newProduct.getName(), response.getBody().getName());
    }

    @Test
    @Transactional
    public void shouldReturnNotFoundWhenUpdateAProductWichNotExist() {
        UpdateProductDto dto = new UpdateProductDto("Oleo", "Oleo descrição", 3.4);
        ResponseEntity<Product> updatedProduct = productsController.updateProduct(dto, 10l);
        assertEquals(HttpStatus.NOT_FOUND, updatedProduct.getStatusCode());
    }
}
