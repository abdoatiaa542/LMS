package com.example.LMS.Controller.Users;


import com.example.LMS.Models.dto.StudentDto;
import com.example.LMS.Models.entity.Student;
import com.example.LMS.Models.mappers.StudentMapper;
import com.example.LMS.Service.imp.Users.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerstudent(@RequestBody StudentDto studentDto) {

        try {
//            System.out.println(" i am in controller ");
//            System.out.println(studentDto.getPassword() + "\n" + studentDto.getName() + "\n" + studentDto.getEmail() + "\n" + studentDto.getPhone_number() + "\n" + studentDto.getBirth_date());
            Student entity = studentMapper.toEntity(studentDto);
//            System.out.println(entity.getPassword() + "\n" + entity.getName() + "\n" + entity.getEmail() + "\n" + entity.getBirth_date() + "\n" + entity.getPhone_number());
            String encodedPassword = passwordEncoder.encode(entity.getPassword());
            entity.setPassword(encodedPassword);
//            System.out.println("ssssss");
            Student savedStudent = studentService.saveStudent(entity);
//            System.out.println("hohhoh");

            if (savedStudent.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user registration failed");
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/all")
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students != null) {
            return studentMapper.toDtoList(students);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentById(id));
        if (student.isPresent()) {
            return ResponseEntity.ok(studentMapper.toDto(student.get()));
        }
        return ResponseEntity.notFound().build();
    }


    //  updata student daetails
    @PutMapping("/update")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        student.setId(id);
        return ResponseEntity.ok(studentMapper.toDto(studentService.saveStudent(student)));
    }


    // handle delete request >> if id not  found  ?
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}