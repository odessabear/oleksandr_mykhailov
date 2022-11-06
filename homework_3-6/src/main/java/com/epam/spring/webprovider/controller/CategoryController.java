package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.controller.dto.CategoryDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import com.epam.spring.webprovider.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/takogonet/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        log.info(this.getClass().getSimpleName() + " getAllCategories() method");
        return categoryService.getAllCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        log.info("getCategory by name {}", name);
        return categoryService.getCategory(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryDTO createCategory(@RequestBody @Validated(OnCreate.class) CategoryDTO categoryDTO) {
        log.info(this.getClass().getSimpleName() + " createCategory() method");
        return categoryService.createCategory(categoryDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) CategoryDTO categoryDTO) {
        log.info("updateCategory with id {}", id);
        return categoryService.updateCategory(id, categoryDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        log.info("deleteCategory by id {}", id);
        categoryService.deleteCategory(id);
    }
}
