package com.example.LMS.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.dto.ClassDto;
import com.example.LMS.Models.entity.Class;
import com.example.LMS.Models.entity.ClassId;
import com.example.LMS.Models.mappers.ClassMapper;
import com.example.LMS.Service.utils.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private ClassMapper classMapper;


    @GetMapping("/all")
    public List<ClassDto> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        if (classes != null) {
            return classMapper.toDtoList(classes);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{classNo}/{courseId}/{cycleId}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable Long classNo, @PathVariable Long courseId, @PathVariable Long cycleId) {
        {
            Optional<Class> sclass = Optional.ofNullable(classService.getClassById(new ClassId(courseId, cycleId, classNo)));

            if (sclass.isPresent()) {
                return ResponseEntity.ok(classMapper.toDto(sclass.get()));
            }
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/save/{classNo}/{courseId}/{cycleId}")
    public ClassDto saveClass(@PathVariable Long classNo , @PathVariable Long courseId, @PathVariable Long cycleId, @RequestBody ClassDto classDto) {

        Class sclass = classMapper.toEntity(classDto);
        sclass.setId(new ClassId(courseId, cycleId, classNo));
        return classMapper.toDto(classService.saveClass(sclass));
    }

    @PutMapping("/update/{classNo}/{courseId}/{cycleId}")
    public ClassDto updateClass(@PathVariable Long classNo, @PathVariable Long courseId, @PathVariable Long cycleId, @RequestBody ClassDto classDto) {

        Class sclass = classMapper.toEntity(classDto);
        sclass.setId(new ClassId(courseId, cycleId, classNo));
        return classMapper.toDto(classService.saveClass(sclass));

    }


    @DeleteMapping("/{classNo}/{courseId}/{cycleId}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long classNo, @PathVariable Long courseId, @PathVariable Long cycleId) {
        classService.deleteClass(new ClassId(courseId, cycleId, classNo));
        return ResponseEntity.noContent().build();
    }


}