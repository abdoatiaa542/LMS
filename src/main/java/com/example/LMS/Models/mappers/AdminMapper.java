package com.example.LMS.Models.mappers;

import com.example.LMS.Models.dto.UsersDto;
import com.example.LMS.Models.entity.Users;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AdminMapper {
    Users toEntity(UsersDto usersDto);

    UsersDto toDto(Users users);

    List<UsersDto> toDtoList(List<Users> users);


//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // ?
//    Admin partialUpdate(AdminDto adminDto, @MappingTarget Admin admin);
}