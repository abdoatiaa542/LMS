package com.example.LMS.Service.utils.Users;



import java.util.List;
import com.example.LMS.Models.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student loadStudent(String username);
    Student getStudentById(Long id);
    Student createStudent(Student student);

    Student updateStudent(String id, Student student);
    void deleteStudent(String id);

}