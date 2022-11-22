package com.example.webproviderapiconsumer.controller;

import com.example.webproviderapiconsumer.model.Tariff;
import com.example.webproviderapiconsumer.service.TariffClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tariffs")
@RequiredArgsConstructor
public class TariffApiTestController {

    private final TariffClient client;

    @GetMapping
    public List<Tariff> getAllTariffs() {
        return client.getAllTariffs();
    }

    @GetMapping("/{id}")
    public Tariff getTariffById(@PathVariable Integer id) {
        return client.getTariffById(id);
    }

    @PostMapping
    public Tariff createTariff(@RequestBody Tariff tariff) {
        Tariff newTariff = client.createTariff(tariff);
        System.out.println(newTariff);
        return newTariff;
    }

    @PutMapping("/{id}")
    public void updateTariff(@PathVariable Integer id, @RequestBody Tariff tariff) {
        client.updateTariff(id, tariff);
    }

    @DeleteMapping("/{id}")
    public void deleteTariff(@PathVariable Integer id) {
        client.deleteTariff(id);
    }
}
