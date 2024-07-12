package com.example.productapi.controller;

import com.example.productapi.domain.Product;
import com.example.productapi.dto.ProductDto;
import com.example.productapi.repository.ProductRepo;
import com.example.productapi.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepo productRepo;


    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createUser(@RequestBody ProductDto productDto, HttpServletRequest request) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}