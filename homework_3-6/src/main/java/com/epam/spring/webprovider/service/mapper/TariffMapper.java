package com.epam.spring.webprovider.service.mapper;

import com.epam.spring.webprovider.controller.dto.TariffDTO;
import com.epam.spring.webprovider.service.model.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDTO tariffToTariffDTO(Tariff tariff);

    Tariff tariffDTOToTariff(TariffDTO tariffDTO);
}
