//package com.example.LMS.Models.mappers;
//
//import com.example.LMS.Models.dto.TestScoreIdDto;
//import com.example.LMS.Models.entity.TestScoreId;
//import org.mapstruct.*;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
//public interface TestScoreIdMapper {
//    TestScoreId toEntity(TestScoreIdDto testScoreIdDto);
//
//    TestScoreIdDto toDto(TestScoreId testScoreId);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    TestScoreId partialUpdate(TestScoreIdDto testScoreIdDto, @MappingTarget TestScoreId testScoreId);
//}