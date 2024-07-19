package com.example.LMS.Controller.Users;


import com.example.LMS.Models.dto.StudentDto;
import com.example.LMS.Models.entity.Student;
import com.example.LMS.Models.mappers.StudentMapper;
import com.example.LMS.Service.imp.Users.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;
    @Autowired
    private StudentMapper studentMapper;


    @GetMapping
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students != null) {
            return studentMapper.toDtoList(students);
        }
        return Collections.emptyList();
    }

    @GetMapping("/get{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentById(id));
        if (student.isPresent()) {
            return ResponseEntity.ok(studentMapper.toDto(student.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        Student studentEntity = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentService.createStudent(studentEntity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Student studentEntity = studentMapper.toEntity(studentDto);
        studentEntity.setId(id);
        return ResponseEntity.ok(studentMapper.toDto(studentService.updateStudent(id, studentEntity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {  // ..
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}