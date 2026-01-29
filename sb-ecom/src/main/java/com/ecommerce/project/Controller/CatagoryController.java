package com.ecommerce.project.Controller;

import com.ecommerce.project.Services.CategoryService;
import com.ecommerce.project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CatagoryController {
    @Autowired
    private final CategoryService categoryService;

    public CatagoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return"category added sucessfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategories(@PathVariable Long categoryId)
    {
        String status = categoryService.deleteCategory(categoryId);
        return status;

    }




    



}
