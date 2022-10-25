package com.epam.spring.webprovider.service.repository;

import com.epam.spring.webprovider.service.model.Tariff;

import java.util.List;

public interface TariffRepository {

    Tariff getTariffById(Integer id);

    List<Tariff> getAllTariffs();

    Tariff createTariff(Tariff tariff);

    Tariff updateTariff(Integer id, Tariff tariff);

    void deleteTariff(Integer id);
}
