package com.example.LMS.Reposatory;

import com.example.LMS.Models.entity.Class;
import com.example.LMS.Models.entity.ClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, ClassId> {
}