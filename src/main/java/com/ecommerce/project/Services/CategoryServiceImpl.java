package com.ecommerce.project.Services;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service

public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;//auto id when user donot give a id


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
         categories.add(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c->c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));

        categories.remove(category);
        return "categoryid "+ categoryId + "was deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category existingCategory = categories.stream()
                .filter(c->c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not Found"));


        existingCategory.setCategoryName(category.getCategoryName());
        return existingCategory;
        }





    }

