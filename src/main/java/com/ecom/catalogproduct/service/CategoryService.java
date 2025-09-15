package com.ecom.catalogproduct.service;

import com.ecom.catalogproduct.model.Category;
import com.ecom.catalogproduct.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category createCategory(Category category) {
       return categoryRepository.save(category);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
