package com.example.LMS.Service.imp.Users;
import com.example.LMS.Models.entity.Student;
import com.example.LMS.Reposatory.Users.StudentRepository;
import com.example.LMS.Service.utils.Users.StudentService;
import com.example.LMS.security.CustomUserDetailsService.CustomStudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CustomStudentDetailsService studentDetailsService;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student loadStudent(String username) {
        UserDetails userDetails = studentDetailsService.loadUserByUsername(username);
        return Student.builder()
                .name(userDetails.getUsername())
                .password(userDetails.getPassword())
                .studentAuthorities(userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .build();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(String id, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(String id) {

    }

    public Student updateStudent(long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setBirthDate(studentDetails.getBirthDate());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        return studentRepository.save(student);
    }

    public void deleteStudent(long  id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }


}