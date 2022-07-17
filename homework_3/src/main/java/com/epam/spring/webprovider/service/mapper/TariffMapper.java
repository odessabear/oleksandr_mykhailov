package com.epam.spring.webprovider.service.mapper;

import com.epam.spring.webprovider.controller.dto.TariffDTO;
import com.epam.spring.webprovider.service.model.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffMapper {

    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDTO tariffToTariffDTO(Tariff tariff);

    Tariff tariffDTOToTariff(TariffDTO tariffDTO);

    List<TariffDTO> tariffsToTariffsDTO(List<Tariff> tariffs);
}
