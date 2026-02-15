package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@RequiredArgsConstructor


public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long categoryId;
    @NotBlank
    @Size(min = 5 , message = "category name must contain atleast 5 character")
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