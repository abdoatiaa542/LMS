package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Admin;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Admin}
 */
@Value
@Builder
public class AdminDto implements Serializable {
    Long id;
    String username;
    String password;
    String email;
    String role;
    List<String> adminAuthorities;   //  ??
}