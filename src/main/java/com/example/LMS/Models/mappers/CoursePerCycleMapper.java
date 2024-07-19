package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.CoursePerCycleDto;
import com.example.LMS.Models.dto.CoursePerCycleIdDto;
import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Models.entity.CoursePerCycleId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CoursePerCycleMapper {

    CoursePerCycleMapper INSTANCE = Mappers.getMapper(CoursePerCycleMapper.class);

    @Mapping(target = "id", source = "id")
    CoursePerCycleDto toDto(CoursePerCycle coursePerCycle);

    @Mapping(target = "id", source = "id")
    CoursePerCycle toEntity(CoursePerCycleDto coursePerCycleDto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    CoursePerCycleId toEntity(CoursePerCycleIdDto idDto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    CoursePerCycleIdDto toDto(CoursePerCycleId id);

    default List<CoursePerCycleId> mapCoursePerCycleIdDtoList(List<CoursePerCycleIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<CoursePerCycleIdDto> mapCoursePerCycleIdList(List<CoursePerCycleId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }

    List<CoursePerCycleDto> toDtoList(List<CoursePerCycle> coursePerCycles);
}