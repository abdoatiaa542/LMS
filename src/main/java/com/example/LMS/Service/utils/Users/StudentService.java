package com.example.LMS.Service.utils.Users;


import java.util.List;

import com.example.LMS.Models.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);

//    Student updateStudent(long id, Student student);

}