package com.example.LMS.Controller;

import java.util.List;
import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Models.entity.TestScoreId;
import com.example.LMS.Service.utils.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-scores")
public class TestScoreController {

    @Autowired
    private TestScoreService testScoreService;

    @GetMapping
    public List<TestScore> getAllTestScores() {
        return testScoreService.getAllTestScores();
    }

    @GetMapping("/{id}")
    public TestScore getTestScoreById(@PathVariable TestScoreId id) {
        return testScoreService.getTestScoreById(id);
    }

    @PostMapping
    public TestScore createTestScore(@RequestBody TestScore testScore) {
        return testScoreService.createTestScore(testScore);
    }

//    @PutMapping("/{id}")
//    public TestScore updateTestScore(@PathVariable TestScoreId id, @RequestBody TestScore testScore) {
//        return testScoreService.updateTestScore(id, testScore);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestScore(@PathVariable TestScoreId id) {
        testScoreService.deleteTestScore(id);
        return ResponseEntity.noContent().build();
    }
}