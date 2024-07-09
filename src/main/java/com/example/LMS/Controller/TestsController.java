package com.example.LMS.Controller;


import com.example.LMS.Models.entity.Tests;
import com.example.LMS.Service.utils.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;

    @GetMapping
    public List<Tests> getAllTests() {
        return testsService.getAllTests();
    }

//    @GetMapping("/{courseId}/{cycleId}/{testNo}")
//    public ResponseEntity<Tests> getTestById(@PathVariable String courseId, @PathVariable String cycleId, @PathVariable int testNo) {
//        Tests test = testsService.getTestById(courseId, cycleId, testNo);
//        return ResponseEntity.ok(test);
//    }

    @PostMapping
    public Tests saveTest(@RequestBody Tests test) {
        return testsService.saveTest(test);
    }

//    @DeleteMapping("/{courseId}/{cycleId}/{testNo}")
//    public void deleteTest(@PathVariable String courseId, @PathVariable String cycleId, @PathVariable int testNo) {
//        testsService.deleteTest(courseId, cycleId, testNo);
//    }
}