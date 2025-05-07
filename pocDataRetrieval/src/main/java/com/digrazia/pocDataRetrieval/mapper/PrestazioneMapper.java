package com.digrazia.pocDataRetrieval.mapper;

import com.digrazia.pocDataRetrieval.model.dto.PrestazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)

public interface PrestazioneMapper {
    PrestazioneDTO toDto(Prestazione prestazione);
    List<PrestazioneDTO> toDtoList(List<Prestazione> prestazione);
}
