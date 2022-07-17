package com.epam.spring.webprovider.service.repository.impl;

import com.epam.spring.webprovider.service.model.Category;
import com.epam.spring.webprovider.service.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final List<Category> categories = new ArrayList<>();

    @Override
    public Category getCategory(String name) {
        return categories.stream()
                .filter(category -> category.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category doesn't exist"));
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public Category createCategory(Category category) {
        category.setId(categories.size() + 1);
        categories.add(category);
        return category;
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        Category currentCategory = categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category doesn't exist"));
        categories.remove(currentCategory);
        category.setId(currentCategory.getId());
        categories.add(category);
        return category;
    }

    @Override
    public void deleteCategory(Integer id) {
        categories.removeIf(category -> category.getId().equals(id));
    }
}
