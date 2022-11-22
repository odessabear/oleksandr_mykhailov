package com.epam.spring.webprovider.service;

import com.epam.spring.webprovider.controller.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO getCategory(String name);

    List<CategoryDTO> getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO);

    void deleteCategory(Integer id);
}
