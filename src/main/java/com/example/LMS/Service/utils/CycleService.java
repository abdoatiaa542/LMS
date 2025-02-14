package com.example.LMS.Service.utils;


import java.util.List;
import com.example.LMS.Models.entity.Cycle;

public interface CycleService {

    List<Cycle> getAllCycles();

    Cycle getCycleById(Long id);

    Cycle saveCycle(Cycle cycle);

    void deleteCycle(Long id);
}