package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Users;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Users}
 */
@Value
@Builder
public class UsersDto implements Serializable {
    Long id;
    String username;
    String password;
    String email;
    String role;
    List<String> authorities;   //  ??
}