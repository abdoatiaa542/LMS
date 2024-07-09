package com.example.LMS.Reposatory;

import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Tests, TestId> {
}
