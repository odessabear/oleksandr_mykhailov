package com.epam.spring.webprovider.service.repository.impl;

import com.epam.spring.webprovider.service.model.Category;
import com.epam.spring.webprovider.service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final List<Category> categories = new ArrayList<>();

    @Override
    public Category getCategory(String name) {
        log.info(this.getClass().getSimpleName() + " getCategory() method");
        return categories.stream()
                .filter(category -> category.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category doesn't exist"));
    }

    @Override
    public List<Category> getAllCategories() {
        log.info(this.getClass().getSimpleName() + " getCategory() method");
        return new ArrayList<>(categories);
    }

    @Override
    public Category createCategory(Category category) {
        log.info(this.getClass().getSimpleName() + " createCategory() method");
        category.setId(categories.size() + 1);
        categories.add(category);
        return category;
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        log.info(this.getClass().getSimpleName() + " updateCategory() method");
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
        log.info(this.getClass().getSimpleName() + " deleteCategory() method");
        categories.removeIf(category -> category.getId().equals(id));
    }
}
