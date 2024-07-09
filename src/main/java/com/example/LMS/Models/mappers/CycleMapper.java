package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.CycleDto;
import com.example.LMS.Models.entity.Cycle;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CycleMapper {
    Cycle toEntity(CycleDto cycleDto);

    CycleDto toDto(Cycle cycle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cycle partialUpdate(CycleDto cycleDto, @MappingTarget Cycle cycle);
}