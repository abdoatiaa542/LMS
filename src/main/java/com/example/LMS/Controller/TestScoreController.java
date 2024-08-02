package com.example.LMS.Controller;

import com.example.LMS.Models.dto.TestScoreDto;
import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Models.mappers.TestScoreMapper;
import com.example.LMS.Service.utils.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/test-scores")
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

    @GetMapping("/get_by_id/{courseId}")
    public ResponseEntity<TestScoreDto> getTestScoreById(@PathVariable Long courseId) {
        Optional<TestScore> testScore = Optional.ofNullable(testScoreService.getTestScoreById(courseId));
        if (testScore.isPresent()) {
            return ResponseEntity.ok(testScoreMapper.toDto(testScore.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public ResponseEntity<TestScoreDto> createTestScore(@RequestBody TestScoreDto testScoreDto) {
        TestScore testScore = testScoreMapper.toEntity(testScoreDto);
        return ResponseEntity.ok(testScoreMapper.toDto(testScoreService.createTestScore(testScore)));
    }

    @PutMapping("/update")
    public ResponseEntity<TestScoreDto> updateTestScore(@PathVariable Long courseId, @RequestBody TestScoreDto testScoreDto) {
        TestScore testScore = testScoreMapper.toEntity(testScoreDto);
        testScore.setCourseId(courseId);
        return ResponseEntity.ok(testScoreMapper.toDto(testScoreService.createTestScore(testScore)));
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<Void> deleteTestScore(@PathVariable Long courseId) {
        testScoreService.deleteTestScore(courseId);
        return ResponseEntity.noContent().build();
    }


}