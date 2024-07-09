package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Category;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    String description;
}