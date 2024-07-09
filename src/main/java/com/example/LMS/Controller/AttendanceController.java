package com.example.LMS.Controller;


import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import com.example.LMS.Models.entity.ClassId;
import com.example.LMS.Service.utils.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//http://localhost:8080/swagger-ui.html

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{courseId}/{cycleId}/{classNo}/{studentId}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
        Optional<Attendance> attendance = attendanceService
                .getAttendanceById(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));

        if (attendance.isPresent()) {
            return ResponseEntity.ok(attendance.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{courseId}/{cycleId}/{classNo}/{studentId}")
    public void deleteAttendance(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
        attendanceService.deleteAttendance(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
    }
}