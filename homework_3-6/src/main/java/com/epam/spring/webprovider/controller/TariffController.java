package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.controller.dto.TariffDTO;
import com.epam.spring.webprovider.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/takogonet/tariff")
@RequiredArgsConstructor
@Slf4j
public class TariffController {
    private final TariffService tariffService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TariffDTO> getTariffsByCategoryName(@RequestParam(required = false) String categoryName) {
        log.info("getTariffs by categoryName (optional) {}", categoryName);
        return tariffService.getTariffsByCategoryName(categoryName);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TariffDTO getTariffById(@PathVariable Integer id) {
        log.info("getTariff by id {}", id);
        return tariffService.getTariffById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TariffDTO createTariff(@RequestBody TariffDTO tariffDTO) {
        log.info("creatTariff with name {}", tariffDTO.getName());
        return tariffService.createTariff(tariffDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TariffDTO updateTariff(@PathVariable Integer id, @RequestBody TariffDTO tariffDTO) {
        log.info("updateTariff with id {}", id);
        return tariffService.updateTariff(id, tariffDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTariff(@PathVariable Integer id) {
        log.info("deleteTariff with id {}", id);
        tariffService.deleteTariff(id);
    }
}
