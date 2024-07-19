package com.example.LMS.Service.utils;


import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(long id, Category category);

    void deleteCategory(Long id);
}

