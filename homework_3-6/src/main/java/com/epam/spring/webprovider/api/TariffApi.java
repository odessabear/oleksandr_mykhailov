package com.epam.spring.webprovider.api;

import com.epam.spring.webprovider.controller.dto.TariffDTO;
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

@Api(tags = "Tariff management API")
@RequestMapping("api/v1/tariffs")
public interface TariffApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryName", paramType = "query", value = "Category Name")
    })
    @ApiOperation("Get tariff list")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<TariffDTO> getTariffsByCategoryName(@RequestParam (required = false) String categoryName);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Tariff ID")
    })
    @ApiOperation("Get tariff by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    TariffDTO getTariffById(@PathVariable Integer id);

    @ApiOperation("Create tariff")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TariffDTO createTariff(@RequestBody @Validated(OnCreate.class) TariffDTO tariffDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Tariff ID")
    })
    @ApiOperation("Update tariff")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    TariffDTO updateTariff(@PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) TariffDTO tariffDTO);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Tariff ID")
    })
    @ApiOperation("Delete tariff")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteTariff(@PathVariable Integer id);
}
