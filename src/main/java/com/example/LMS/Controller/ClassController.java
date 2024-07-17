package com.example.LMS.Controller;

import java.util.List;
import com.example.LMS.Models.entity.Class;
import com.example.LMS.Models.entity.ClassId;
import com.example.LMS.Service.utils.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Class getClassById(@PathVariable ClassId id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public Class createClass(@RequestBody Class sclass) {
        return classService.createClass(sclass);
    }

    @PutMapping("/{id}")
    public Class updateClass(@PathVariable String id, @RequestBody Class sclass) {
        return classService.updateClass(id, sclass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable ClassId id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}