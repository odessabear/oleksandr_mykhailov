package com.epam.spring.webprovider.service.repository.impl;

import com.epam.spring.webprovider.service.exceptions.TariffNotFoundException;
import com.epam.spring.webprovider.service.model.Tariff;
import com.epam.spring.webprovider.service.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TariffRepositoryImpl implements TariffRepository {
    private final List<Tariff> tariffList = new ArrayList<>();

    @Override
    public Tariff getTariffById(Integer id) {
        log.info(this.getClass().getSimpleName() + " getTariffById() method");
        return tariffList.stream()
                .filter(tariff -> tariff.getId().equals(id))
                .findFirst()
                .orElseThrow(TariffNotFoundException::new);
    }

    @Override
    public List<Tariff> getAllTariffs() {
        log.info(this.getClass().getSimpleName() + " getAllTariffs() method");
        return new ArrayList<>(tariffList);
    }

    @Override
    public Tariff createTariff(Tariff tariff) {
        log.info(this.getClass().getSimpleName() + " create new tariff {}", tariff);
        tariff.setId(tariffList.size() + 1);
        tariffList.add(tariff);
        return tariff;
    }

    @Override
    public Tariff updateTariff(Integer id, Tariff tariff) {
        log.info(this.getClass().getSimpleName() + " updateTariff() method");
        Tariff currentTariff = tariffList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(TariffNotFoundException::new);
        tariffList.remove(currentTariff);
        tariff.setId(currentTariff.getId());
        tariffList.add(tariff);
        return tariff;
    }

    @Override
    public void deleteTariff(Integer id) {
        log.info(this.getClass().getSimpleName() + " deleteTariff() method");
        tariffList.removeIf(tariff -> tariff.getId().equals(id));
    }
}
