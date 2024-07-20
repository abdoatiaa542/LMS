package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.EnrollmentDto;
import com.example.LMS.Models.dto.EnrollmentIdDto;
import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.entity.EnrollmentId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    @Mapping(target = "id", source = "id")
    EnrollmentDto toDto(Enrollment entity);

    @Mapping(target = "id", source = "id")
    Enrollment toEntity(EnrollmentDto dto);

    @Mapping(target = "studentId", source = "studentId")
    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    EnrollmentId toEntity(EnrollmentIdDto idDto);

    @Mapping(target = "studentId", source = "studentId")
    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "cycleId", source = "cycleId")
    EnrollmentIdDto toDto(EnrollmentId id);

    default List<EnrollmentId> mapEnrollmentIdDtoList(List<EnrollmentIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<EnrollmentIdDto> mapEnrollmentIdList(List<EnrollmentId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }

    List<EnrollmentDto> toDtoList(List<Enrollment> enrollments);
}