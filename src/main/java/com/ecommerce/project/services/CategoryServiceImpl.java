package com.ecommerce.project.services;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.Override;
import java.util.ArrayList;
import java.util.List;


@Service

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
//     Long nextId = 1Lauto id when user dprivateonot give a id


    @Override
    public List<Category> getAllCategories()
    {
        List<Category>categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("no category created till now.")
        return categories;
    }


    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null )
            throw new APIException("category with the name" + category.getCategoryName() + "already exists!!!");
         categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId", categoryId));
        categoryRepository.delete(category);


//        List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
//
//        categoryRepository.delete(category);
        return "categoryid "+ categoryId + "was deleted";

    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {


        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId", categoryId));

        existingCategory.setCategoryId(category.getCategoryId());
        Category savedCategory = categoryRepository.save(existingCategory);
        return savedCategory;

//        List<Category> categories = categoryRepository.findAll();
//        Category existingCategory = categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not Found"));
//
//
//        existingCategory.setCategoryName(category.getCategoryName());
//        Category savedCategory = categoryRepository.save(existingCategory);
//        return savedCategory;
        }





    }

