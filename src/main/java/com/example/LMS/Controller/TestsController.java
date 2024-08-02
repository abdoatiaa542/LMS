package com.example.LMS.Controller;


import com.example.LMS.Models.dto.TestsDto;
import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;
import com.example.LMS.Models.mappers.TestsMapper;
import com.example.LMS.Service.utils.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;
    @Autowired
    private TestsMapper testsMapper;

    @GetMapping("/all")
    public List<TestsDto> getAllTests() {
        List<Tests> tests = testsService.getAllTests();
        if (tests != null) {
            return testsMapper.toDtoList(tests);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{course_id}/{cycle_id}/{test_no}")
    public ResponseEntity<TestsDto> getTestById(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no) {

        Optional<Tests> tests = Optional.ofNullable(testsService.getTestById(new TestId(course_id, cycle_id, test_no)));
        if (tests.isPresent()) {
            return ResponseEntity.ok(testsMapper.toDto(tests.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/add_test")
    public TestsDto createTests(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no, @RequestBody TestsDto testsDto) {

        Tests tests = testsMapper.toEntity(testsDto);
        tests.setId(new TestId(course_id, cycle_id, test_no));
        return testsMapper.toDto(testsService.saveTest(tests));
    }

    @PutMapping("/update/{course_id}/{cycle_id}/{test_no}")
    public TestsDto updateTests(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no, @RequestBody TestsDto testsDto) {
        Tests tests = testsMapper.toEntity(testsDto);
        tests.setId(new TestId(course_id, cycle_id, test_no));
        return testsMapper.toDto(testsService.saveTest(tests));
    }

    @DeleteMapping("/delete/{course_id}/{cycle_id}/{test_no}")
    public void deleteTests(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long test_no) {
        testsService.deleteTest(course_id, cycle_id, test_no);
    }


}