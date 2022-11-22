package com.example.webproviderapiconsumer.service;

import com.example.webproviderapiconsumer.model.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TariffClientImpl implements TariffClient {

    @Autowired
    RestTemplate restTemplate;

    final String RESOURCE_URL = "http://localhost:8081/api/v1/tariffs";

    @Override

    public Tariff getTariffById(Integer id) {
        ResponseEntity<Tariff> response = restTemplate.getForEntity(RESOURCE_URL + "/" + id, Tariff.class);
        Tariff tariff = response.getBody();
        System.out.println(tariff);
        return tariff;
    }

    @Override
    public List<Tariff> getAllTariffs() {
        ResponseEntity<Tariff[]> response = restTemplate.getForEntity(RESOURCE_URL, Tariff[].class);
        List<Tariff> tariffs = Arrays.asList(Objects.requireNonNull(response.getBody()));
        System.out.println(tariffs);
        return tariffs;

    }

    @Override
    public Tariff createTariff(Tariff tariff) {
        ResponseEntity<Tariff> response = restTemplate.postForEntity(RESOURCE_URL, tariff, Tariff.class);
        return response.getBody();
    }

    @Override
    public void updateTariff(Integer id, Tariff tariff) {
        restTemplate.put(RESOURCE_URL + "/" + id, tariff);
    }

    @Override
    public void deleteTariff(Integer id) {
        restTemplate.delete(RESOURCE_URL + "/" + id);
    }
}
