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
    public Class updateClass(String id, Class sclass) {
        // Assuming id is a combination of courseId, cycleId, and classNo separated by some delimiter like '-'
        String[] ids = id.split("-");
        Long courseId = Long.parseLong(ids[0]);
        Long cycleId = Long.parseLong(ids[1]);
        Long classNo = Long.parseLong(ids[2]);
        ClassId classId = new ClassId(courseId, cycleId, classNo);

        Optional<Class> optionalClass = classRepository.findById(classId);

        if (optionalClass.isPresent()) {
            Class existingClass = optionalClass.get();
            // Update the fields
            existingClass.setTitle(sclass.getTitle());
            existingClass.setDate(sclass.getDate());
            existingClass.setStartTime(sclass.getStartTime());
            existingClass.setEndTime(sclass.getEndTime());
            existingClass.setTeacher(sclass.getTeacher());

            return classRepository.save(existingClass);
        } else {
            // Handle the case where the class was not found
            // This could throw an exception or return null, depending on your use case
            return null;
        }
    }



    @Override
    public void deleteClass(ClassId id) {
        classRepository.deleteById(id);
    }
}