package com.epam.spring.webprovider.controller;

import com.epam.spring.webprovider.api.TariffApi;
import com.epam.spring.webprovider.controller.dto.TariffDTO;
import com.epam.spring.webprovider.service.TariffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TariffController implements TariffApi {
    private final TariffService tariffService;

    public List<TariffDTO> getTariffsByCategoryName(String categoryName) {
        log.info("getTariffs by categoryName (optional) {}", categoryName);
        return tariffService.getTariffsByCategoryName(categoryName);
    }

    public TariffDTO getTariffById(@PathVariable int id) {
        log.info("getTariff by id {}", id);
        return tariffService.getTariffById(id);
    }

    public TariffDTO createTariff(TariffDTO tariffDTO) {
        log.info("creatTariff with name {}", tariffDTO.getName());
        return tariffService.createTariff(tariffDTO);
    }

    public TariffDTO updateTariff(int id, TariffDTO tariffDTO) {
        log.info("updateTariff with id {}", id);
        return tariffService.updateTariff(id, tariffDTO);
    }

    public void deleteTariff(int id) {
        log.info("deleteTariff with id {}", id);
        tariffService.deleteTariff(id);
    }
}
