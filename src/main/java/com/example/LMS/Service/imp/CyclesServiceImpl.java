package com.example.LMS.Service.imp;


import com.example.LMS.Models.entity.Cycle;
import com.example.LMS.Service.utils.CycleService;
import com.example.LMS.Reposatory.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyclesServiceImpl implements CycleService {

    @Autowired
    private CycleRepository cyclesRepository;

    @Override
    public List<Cycle> getAllCycles() {
        return cyclesRepository.findAll();
    }

    @Override
    public Cycle getCycleById(Long id) {
        return cyclesRepository.findById(id).orElse(null);
    }

    @Override
    public Cycle saveCycle(Cycle cycle) {
        return cyclesRepository.save(cycle);
    }

    @Override
    public void deleteCycle(Long id) {
        cyclesRepository.deleteById(id);
    }
}