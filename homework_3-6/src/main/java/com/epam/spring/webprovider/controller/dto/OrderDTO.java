package com.epam.spring.webprovider.controller.dto;

import com.epam.spring.webprovider.controller.dto.group.OnCreate;
import com.epam.spring.webprovider.controller.dto.group.OnUpdate;
import com.epam.spring.webprovider.service.model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    @Null(message = "'id' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Integer id;

    @NotNull(message = "'userDTO' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private UserDTO user;

    @NotNull(message = "'tariffList' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private List<TariffDTO> tariffList;

    @NotNull(message = "'orderCost' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @PositiveOrZero(message = "'orderCost' shouldn't be negative", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal orderCost;

    @Null(message = "'createDate' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Timestamp createDate;

    @Null(message = "'updateDate' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private Timestamp updateDate;

    @Null(message = "'status' should be absent in request", groups = {OnCreate.class, OnUpdate.class})
    private OrderStatus orderStatus;
}
