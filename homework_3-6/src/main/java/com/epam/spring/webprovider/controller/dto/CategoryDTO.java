package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Builder
public class CategoryDTO {

    @Null(message = "'CategoryDto.id' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Integer id;

    @NotBlank(message = "'name' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String name;
}
