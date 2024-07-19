package com.example.LMS.Controller;


import com.example.LMS.Models.dto.TestsDto;
import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;
import com.example.LMS.Models.mappers.TestsMapper;
import com.example.LMS.Service.utils.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;
    @Autowired
    private TestsMapper testsMapper;



    @GetMapping("/get_all_test")
    public List<TestsDto> getAllTests() {
        List<Tests> tests = testsService.getAllTests();
        if (tests != null) {
            return testsMapper.toDtoList(tests);
        }
        return Collections.emptyList();
    }


    @PostMapping("/add_test")
    public TestsDto createTests(@PathVariable Long course_id, @PathVariable Long cycle_id,@PathVariable Long test_no, @RequestBody TestsDto testsDto) {

        Tests tests = testsMapper.toEntity(testsDto);
        tests.setId(new TestId(course_id, cycle_id, test_no));
        return testsMapper.toDto(testsService.saveTest(tests));
    }





}