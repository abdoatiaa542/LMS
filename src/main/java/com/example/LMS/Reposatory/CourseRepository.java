package com.example.LMS.Reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LMS.Models.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}