package com.example.LMS.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.dto.TestScoreDto;
import com.example.LMS.Models.dto.TestScoreIdDto;
import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Models.entity.TestScoreId;
import com.example.LMS.Models.mappers.TestScoreMapper;
import com.example.LMS.Service.utils.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-scores")
public class TestScoreController {

    @Autowired
    private TestScoreService testScoreService;

    @Autowired
    private TestScoreMapper testScoreMapper;


    @GetMapping("/all")
    public List<TestScoreDto> getAllTestScores() {
        List<TestScore> testScores = testScoreService.getAllTestScores();
        if (testScores != null) {
            return testScoreMapper.toDtoList(testScores);
        }
        return Collections.emptyList();
    }

    @GetMapping("/get_testScore_by_StudentId/{id}")
    public ResponseEntity<TestScoreDto> getTestScoreById(@PathVariable Long student_id, @PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no) {
        Optional<TestScore> testScore = Optional.ofNullable(testScoreService.getTestScoreById(new TestScoreId(course_id, cycle_id, test_no, student_id)));
        if (testScore.isPresent()) {
            return ResponseEntity.ok(testScoreMapper.toDto(testScore.get()));
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping("/add_score")
    public TestScoreDto createTestScore(@PathVariable Long student_id, @PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no, @RequestBody TestScoreDto testScoreDto) {
        // entity
        TestScore testScore = testScoreMapper.toEntity(testScoreDto);
        // add id to entity
        testScore.setId(new TestScoreId(course_id, cycle_id, test_no, student_id));
        // create score
        return testScoreMapper.toDto(testScoreService.createTestScore(testScore));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestScore(@PathVariable Long student_id, @PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no, @RequestBody TestScoreDto testScoreDto) {
        testScoreService.deleteTestScore(new TestScoreId(course_id, cycle_id, test_no, student_id));
        return ResponseEntity.noContent().build();
    }
}