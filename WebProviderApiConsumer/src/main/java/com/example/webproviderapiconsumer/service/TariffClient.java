package com.example.webproviderapiconsumer.service;

import com.example.webproviderapiconsumer.model.Tariff;

import java.util.List;

public interface TariffClient {

    Tariff getTariffById(Integer id);

    List<Tariff> getAllTariffs();

    Tariff createTariff(Tariff tariff);

    void updateTariff(Integer id, Tariff tariff);

    void deleteTariff(Integer id);
}
