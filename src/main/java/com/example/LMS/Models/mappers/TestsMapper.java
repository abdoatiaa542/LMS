package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.TestIdDto;
import com.example.LMS.Models.dto.TestsDto;
import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TestsMapper {

    TestsMapper INSTANCE = Mappers.getMapper(TestsMapper.class);

    @Mapping(target = "id", source = "id")
    TestsDto toDto(Tests tests);

    @Mapping(target = "id", source = "id")
    Tests toEntity(TestsDto testsDto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    @Mapping(target = "testNo", source = "testNo")
    TestId toEntity(TestIdDto idDto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    @Mapping(target = "testNo", source = "testNo")
    TestIdDto toDto(TestId id);

    default List<TestId> mapTestIdDtoList(List<TestIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<TestIdDto> mapTestIdList(List<TestId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }
}
