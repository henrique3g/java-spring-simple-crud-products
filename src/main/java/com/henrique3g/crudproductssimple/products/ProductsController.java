package com.henrique3g.crudproductssimple.products;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        /*
         * if (optionalProduct.isEmpty()) { return ResponseEntity.notFound().build(); }
         * return ResponseEntity.ok(optionalProduct.get());
         */
        return ResponseEntity.of(optionalProduct);
    }

    @PostMapping()
    @Transactional
    public Map<String, Long> createProduct(@Valid @RequestBody CreateProductDto productRequest) {
        Product product = productRequest.toModel();
        Product savedProduct = productRepository.save(product);
        // return savedProduct.getId();
        return Map.of("id", savedProduct.getId());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid UpdateProductDto productRequest,
            @PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product savedProduct = productRepository.save(productRequest.toModel(optionalProduct.get()));
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(optionalProduct.get());
        return ResponseEntity.noContent().build();
    }
}
