package com.ecom.catalogproduct.controller;

import com.ecom.catalogproduct.dto.CreateProductDto;
import com.ecom.catalogproduct.model.Product;
import com.ecom.catalogproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
    private final ProductService productService;
    @PostMapping("create")
    public ResponseEntity<Product> createProduct(
            @RequestBody CreateProductDto createProductDto
    ) {
        productService.createProduct(createProductDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("all")
    public List<Product> getAllProducts() {
        return  productService.getAllProducts();
    }
    @GetMapping("allById/{id}")
    public List<Product> getAllProductsByCategoryId(
          @PathVariable  Long id
    ) {
        return productService.getProductByCategoryId(id);
    }
}
