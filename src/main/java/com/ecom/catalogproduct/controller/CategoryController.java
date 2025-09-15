package com.ecom.catalogproduct.controller;

import com.ecom.catalogproduct.model.Category;
import com.ecom.catalogproduct.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("createCategory")
    public Category createCategory(
          @RequestBody Category category
    ) {
        return categoryService.createCategory(category);
    }
    @GetMapping("all")
    public List<Category> getAllCategories() {
      return categoryService.getAllCategories();
    }
}
