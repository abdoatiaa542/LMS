package com.example.LMS.Controller;

import com.example.LMS.Models.dto.CycleDto;
import com.example.LMS.Models.entity.Cycle;
import com.example.LMS.Models.mappers.CycleMapper;
import com.example.LMS.Service.utils.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/cycles")
public class CyclesController {

    @Autowired
    private CycleService cyclesService;
    @Autowired
    private CycleMapper cycleMapper;


    @GetMapping("/all")
    public List<CycleDto> getAllCycles() {
        List<Cycle> cycles = cyclesService.getAllCycles();
        if (cycles != null) {
            return cycleMapper.toDtoList(cycles);
        }
        return Collections.emptyList();
    }

    @PostMapping("/save")
    public ResponseEntity<CycleDto>  createCycle(@RequestBody CycleDto cycleDto) {
        Cycle cycle = cycleMapper.toEntity(cycleDto);
        Cycle createdCycle = cyclesService.saveCycle(cycle);
        return ResponseEntity.ok(cycleMapper.toDto(createdCycle));

    }




}