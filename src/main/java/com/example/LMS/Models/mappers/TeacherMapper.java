package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.TeacherDto;
import com.example.LMS.Models.entity.Teacher;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeacherMapper {
    Teacher toEntity(TeacherDto teacherDto);

    TeacherDto toDto(Teacher teacher);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Teacher partialUpdate(TeacherDto teacherDto, @MappingTarget Teacher teacher);

    List<TeacherDto> toDtoList(List<Teacher> teachers);
}