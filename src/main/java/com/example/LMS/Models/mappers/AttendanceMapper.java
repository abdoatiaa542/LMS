package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.AttendanceDto;
import com.example.LMS.Models.dto.AttendanceIdDto;
import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    @Mapping(target = "id", source = "id")
    AttendanceDto toDto(Attendance entity);

    @Mapping(target = "id", source = "id")
    Attendance toEntity(AttendanceDto dto);

    @Mapping(target = "classId", source = "classId")
    @Mapping(target = "studentId", source = "studentId")
    AttendanceId toEntity(AttendanceIdDto idDto);

    @Mapping(target = "classId", source = "classId")
    @Mapping(target = "studentId", source = "studentId")
    AttendanceIdDto toDto(AttendanceId id);

    default List<AttendanceId> mapAttendanceIdDtoList(List<AttendanceIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<AttendanceIdDto> mapAttendanceIdList(List<AttendanceId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }

    List<AttendanceDto> toDtoList(List<Attendance> allAttendance);

}