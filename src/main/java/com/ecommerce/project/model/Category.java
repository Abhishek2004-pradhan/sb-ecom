package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "categories")


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long categoryId;
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}


//@Id
// @GeneratedValue(strategy = GnerationType.SEQUENCE,generator="order_sequence")
//@SequenceGenerator(name = "order_seq" , sequenceName="order_sequence", allocationSize = 1)
//private Long id;
//
//
//
//
//
//
//
//
//
//
//
//