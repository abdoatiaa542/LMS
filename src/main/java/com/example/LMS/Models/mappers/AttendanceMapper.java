package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.AttendanceDto;
import com.example.LMS.Models.dto.AttendanceIdDto;
import com.example.LMS.Models.dto.ClassIdDto;
import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import com.example.LMS.Models.entity.ClassId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);


    AttendanceDto toDto(Attendance entity);


    Attendance toEntity(AttendanceDto dto);

    AttendanceId toEntity(AttendanceIdDto idDto);


    AttendanceIdDto toDto(AttendanceId id);


    ClassId toEntity(ClassIdDto classIdDto);

    ClassIdDto toDto(ClassId classId);

    default List<AttendanceId> mapAttendanceIdDtoList(List<AttendanceIdDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<AttendanceIdDto> mapAttendanceIdList(List<AttendanceId> ids) {
        return ids.stream().map(this::toDto).collect(Collectors.toList());
    }

    List<AttendanceDto> toDtoList(List<Attendance> attendances);


}
