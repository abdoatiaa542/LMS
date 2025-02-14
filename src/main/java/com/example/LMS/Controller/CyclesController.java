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
import java.util.Optional;


@RestController
@RequestMapping("/v1/cycles")
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


    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<CycleDto> getCycleById(@PathVariable Long id) {
        Optional<Cycle> cycle = Optional.ofNullable(cyclesService.getCycleById(id));
        if (cycle.isPresent()) {
            return ResponseEntity.ok(cycleMapper.toDto(cycle.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public ResponseEntity<CycleDto> createCycle(@RequestBody CycleDto cycleDto) {
        Cycle cycle = cycleMapper.toEntity(cycleDto);
        Cycle createdCycle = cyclesService.saveCycle(cycle);
        return ResponseEntity.ok(cycleMapper.toDto(createdCycle));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CycleDto> updateCycle(@PathVariable Long id, @RequestBody CycleDto cycleDto) {
        Cycle cycle = cycleMapper.toEntity(cycleDto);
        cycle.setId(id);
        Cycle updatedCycle = cyclesService.saveCycle(cycle);
        return ResponseEntity.ok(cycleMapper.toDto(updatedCycle));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCycle(@PathVariable Long id) {
        cyclesService.deleteCycle(id);
        return ResponseEntity.noContent().build();
    }


}