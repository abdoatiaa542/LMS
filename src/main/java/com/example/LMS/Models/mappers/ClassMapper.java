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

    ClassDto toDto(Class entity);

    Class toEntity(ClassDto dto);

    ClassId toEntity(ClassIdDto idDto);

    ClassIdDto toDto(ClassId id);

    default List<ClassId> mapClassIdDtoList(List<ClassIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<ClassIdDto> mapClassIdList(List<ClassId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }

    List<ClassDto> toDtoList(List<Class> classes);
}