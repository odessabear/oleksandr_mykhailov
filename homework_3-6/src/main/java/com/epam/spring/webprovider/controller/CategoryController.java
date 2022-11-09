package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.api.CategoryApi;
import com.epam.spring.webprovider.controller.dto.CategoryDTO;
import com.epam.spring.webprovider.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    public List<CategoryDTO> getAllCategories() {
        log.info(this.getClass().getSimpleName() + " getAllCategories() method");
        return categoryService.getAllCategories();
    }

    public CategoryDTO getCategoryByName(String name) {
        log.info("getCategory by name {}", name);
        return categoryService.getCategory(name);
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        log.info(this.getClass().getSimpleName() + " createCategory() method");
        return categoryService.createCategory(categoryDTO);
    }

    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        log.info("updateCategory with id {}", id);
        return categoryService.updateCategory(id, categoryDTO);
    }

    public void deleteCategory(Integer id) {
        log.info("deleteCategory by id {}", id);
        categoryService.deleteCategory(id);
    }
}
