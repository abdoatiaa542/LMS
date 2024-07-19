package com.example.LMS.Controller;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.dto.CategoryDto;
import com.example.LMS.Models.entity.Category;
import com.example.LMS.Models.mappers.CategoryMapper;
import com.example.LMS.Service.utils.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories != null) {
            return categoryMapper.toDtoList(categories);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = Optional.ofNullable(categoryService.getCategoryById(id));
        if (category.isPresent()) {
            return ResponseEntity.ok(categoryMapper.toDto(category.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category createdCategory = categoryService.createCategory(category);
        return categoryMapper.toDto(createdCategory);
    }


    @PutMapping("/update/{id}")
    public CategoryDto updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        category.setId(id);
        Category updatedCategory = categoryService.updateCategory(id, category);
        return categoryMapper.toDto(updatedCategory);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}