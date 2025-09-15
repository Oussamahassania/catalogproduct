package com.ecom.catalogproduct.dto;

import lombok.Data;

@Data
public class CreateProductDto {
    private Long categoryId;
    private String productName;
    private String description;
    private Double price;
    private String imageUrl;
}
