package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.AdminDto;
import com.example.LMS.Models.entity.Admin;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AdminDto adminDto);

    AdminDto toDto(Admin admin);

    List<AdminDto> toDtoList(List<Admin> admins);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // ?
//    Admin partialUpdate(AdminDto adminDto, @MappingTarget Admin admin);
}