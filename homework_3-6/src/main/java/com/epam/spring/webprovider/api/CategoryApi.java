package com.epam.spring.webprovider.api;

import com.epam.spring.webprovider.controller.dto.CategoryDTO;
import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Category management API")
@RequestMapping("api/v1/categories")
public interface CategoryApi {

    @ApiOperation("Get categories list")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CategoryDTO> getAllCategories();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", paramType = "path", required = true, value = "Category Name")
    })
    @ApiOperation("Get categories list")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{name}")
    CategoryDTO getCategoryByName(@PathVariable String name);

    @ApiOperation("Create category")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CategoryDTO createCategory(@RequestBody @Validated(OnCreate.class) CategoryDTO categoryDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Category ID")
    })
    @ApiOperation("Update category")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    CategoryDTO updateCategory(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) CategoryDTO categoryDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Category ID")
    })
    @ApiOperation("Delete category")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Integer id);
}
