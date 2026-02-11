package com.ecommerce.project.controller;

import com.ecommerce.project.services.CategoryService;
import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController


public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category>categories=categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity <String> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>("category added sucessfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long categoryId)
    {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
            //return ResponseEntity.status(HttpStatus.ok).boddy(status);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId){
        try{
            Category savedCategory = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category with category id" + category, HttpStatus.OK);
        }
        catch (ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }










}
