package br.com.microservices.provider.controllers;

import br.com.microservices.provider.models.Product;
import br.com.microservices.provider.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/{state}")
    public ResponseEntity<List<Product>> getProductsByState(@PathVariable final String state) {
        log.info("Getting products for state: {}", state);
        var products = productService.getProductsByState(state);
        log.info("Getted products: {}", products);
        return ResponseEntity.ok(products);
    }
}
