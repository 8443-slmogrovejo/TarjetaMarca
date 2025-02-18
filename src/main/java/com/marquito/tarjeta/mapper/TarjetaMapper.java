package com.marquito.tarjeta.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.marquito.tarjeta.dto.TarjetaDTO;
import com.marquito.tarjeta.modelo.Tarjeta;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TarjetaMapper {

    TarjetaDTO toDTO(Tarjeta modelo);
    Tarjeta toModel(TarjetaDTO dto);
}
