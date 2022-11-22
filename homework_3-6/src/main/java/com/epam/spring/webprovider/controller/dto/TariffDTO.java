package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TariffDTO {

    @Null(message = "'TariffDto.id' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Integer id;

    @NotBlank(message = "'name' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "'description' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @NotNull(message = "'price' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal price;

    @NotNull(message = "'categoryDTO' shouldn't be empty", groups = OnCreate.class)
    @Null(message = "'categoryDTO' should be absent in request", groups = OnUpdate.class)
    private CategoryDTO category;
}
