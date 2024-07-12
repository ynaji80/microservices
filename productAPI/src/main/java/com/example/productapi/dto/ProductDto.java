package com.example.productapi.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String description;
    private String category;
    private String imageUrl;
    private Double price;
}