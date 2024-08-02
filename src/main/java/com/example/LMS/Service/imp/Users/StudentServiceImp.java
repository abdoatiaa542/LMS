package com.example.LMS.Service.imp.Users;

import com.example.LMS.Models.entity.Student;
import com.example.LMS.Reposatory.Users.StudentRepository;
import com.example.LMS.Service.utils.Users.StudentService;
import com.example.LMS.exception.common.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found " + id);
        }
        studentRepository.deleteById(id);
    }

}





