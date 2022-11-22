package com.epam.spring.webprovider.service.repository;

import com.epam.spring.webprovider.service.model.Category;

import java.util.List;

public interface CategoryRepository {
    Category getCategory(String name);

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Integer id, Category category);

    void deleteCategory(Integer id);
}
