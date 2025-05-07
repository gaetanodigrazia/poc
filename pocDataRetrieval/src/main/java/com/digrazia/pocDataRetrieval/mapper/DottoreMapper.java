package com.digrazia.pocDataRetrieval.mapper;

import com.digrazia.pocDataRetrieval.model.dto.DottoreDTO;
import com.digrazia.pocDataRetrieval.model.entity.Dottore;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DottoreMapper {
    DottoreDTO toDto(Dottore dottore);
    List<DottoreDTO> toDtoList(List<Dottore> dottoreList);
}
