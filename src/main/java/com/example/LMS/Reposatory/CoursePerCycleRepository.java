package com.example.LMS.Reposatory;


import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Models.entity.CoursePerCycleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePerCycleRepository extends JpaRepository<CoursePerCycle, CoursePerCycleId> {
}