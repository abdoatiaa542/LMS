package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.ClassDto;
import com.example.LMS.Models.dto.ClassIdDto;
import com.example.LMS.Models.entity.Class;
import com.example.LMS.Models.entity.ClassId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(target = "id", source = "id")
    ClassDto toDto(Class entity);

    @Mapping(target = "id", source = "id")
    Class toEntity(ClassDto dto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    @Mapping(target = "classNo", source = "classNo")
    ClassId toEntity(ClassIdDto idDto);

    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    @Mapping(target = "classNo", source = "classNo")
    ClassIdDto toDto(ClassId id);

    default List<ClassId> mapClassIdDtoList(List<ClassIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<ClassIdDto> mapClassIdList(List<ClassId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }
}