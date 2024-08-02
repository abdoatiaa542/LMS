package com.example.LMS.Service.imp.Users;

import com.example.LMS.Models.entity.Teacher;
import com.example.LMS.Reposatory.Users.TeacherRepository;
import com.example.LMS.Service.utils.Users.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher updateTeacher(long id, Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }


    @Override
    public Teacher savaTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


}