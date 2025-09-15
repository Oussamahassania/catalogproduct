package com.ecom.catalogproduct.service;

import com.ecom.catalogproduct.dto.CreateProductDto;
import com.ecom.catalogproduct.model.Category;
import com.ecom.catalogproduct.model.Product;
import com.ecom.catalogproduct.repository.CategoryRepository;
import com.ecom.catalogproduct.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public void createProduct(CreateProductDto createProductDto) {
    Category category = categoryRepository.findById(createProductDto.getCategoryId()).orElseThrow(
            ()->new RuntimeException("Category not found"));
    Product product = new Product();
    product.setName(createProductDto.getProductName());
    product.setCategory(category);
    product.setDescription(createProductDto.getDescription());
    product.setPrice(createProductDto.getPrice());
    product.setImageUrl(createProductDto.getImageUrl());
        productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getProductByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }
}
