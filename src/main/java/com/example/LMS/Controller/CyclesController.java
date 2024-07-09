package com.example.LMS.Controller;

import com.example.LMS.Models.entity.Cycle;
import com.example.LMS.Service.utils.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cycles")
public class CyclesController {

    @Autowired
    private CycleService cyclesService;


    @GetMapping
    public List<Cycle> getAllCycles() {
        return cyclesService.getAllCycles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cycle> getCycleById(@PathVariable String id) {
        Cycle cycle = cyclesService.getCycleById(id);
        return ResponseEntity.ok(cycle);
    }

    @PostMapping
    public Cycle saveCycle(@RequestBody Cycle cycle) {
        return cyclesService.saveCycle(cycle);
    }

    @DeleteMapping("/{id}")
    public void deleteCycle(@PathVariable String id) {
        cyclesService.deleteCycle(id);
    }
}