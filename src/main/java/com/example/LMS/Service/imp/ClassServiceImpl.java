package com.example.LMS.Service.imp;



import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.entity.ClassId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LMS.Models.entity.Class;
import com.example.LMS.Reposatory.ClassRepository;
import com.example.LMS.Service.utils.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Class getClassById(ClassId id) {
        return classRepository.findById(id).orElse(null);
    }

    @Override
    public Class createClass(Class sclass) {
        return classRepository.save(sclass);
    }

    @Override
    public Class updateClass(Class sclass) {
        return classRepository.save(sclass);
    }


    @Override
    public void deleteClass(ClassId id) {
        classRepository.deleteById(id);
    }
}