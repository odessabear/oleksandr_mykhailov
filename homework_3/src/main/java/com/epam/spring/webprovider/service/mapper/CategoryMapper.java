package com.epam.spring.webprovider.service.mapper;

import com.epam.spring.webprovider.controller.dto.CategoryDTO;
import com.epam.spring.webprovider.service.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> categoriesToCategoriesDTO(List<Category> categories);
}
