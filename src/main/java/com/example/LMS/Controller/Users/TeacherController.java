package com.example.LMS.Controller.Users;

import com.example.LMS.Models.dto.TeacherDto;
import com.example.LMS.Models.entity.Teacher;
import com.example.LMS.Models.mappers.TeacherMapper;
import com.example.LMS.Service.imp.Users.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherServiceImp teacherService;

    @Autowired
    private TeacherMapper teacherMapper;


    @GetMapping("/all")
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        if (teachers != null) {
            return teacherMapper.toDtoList(teachers);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = Optional.ofNullable(teacherService.getTeacherById(id));
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacherMapper.toDto(teacher.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public TeacherDto createTeacher(@RequestBody TeacherDto teacher) {
        // to entity
        Teacher teacherEntity = teacherMapper.toEntity(teacher);
        return teacherMapper.toDto(teacherService.createTeacher(teacherEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDetails) {
        Teacher teacherEntity = teacherMapper.toEntity(teacherDetails);
        teacherEntity.setTeacherId(id);
        return ResponseEntity.ok(teacherMapper.toDto(teacherService.updateTeacher(id, teacherEntity)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}