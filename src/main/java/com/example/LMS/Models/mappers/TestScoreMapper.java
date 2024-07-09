package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.TestScoreDto;
import com.example.LMS.Models.entity.TestScore;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestScoreMapper {
    TestScore toEntity(TestScoreDto testScoreDto);

    TestScoreDto toDto(TestScore testScore);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TestScore partialUpdate(TestScoreDto testScoreDto, @MappingTarget TestScore testScore);
}