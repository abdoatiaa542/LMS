package com.example.LMS.Controller;


import com.example.LMS.Models.dto.AttendanceDto;
import com.example.LMS.Models.dto.AttendanceIdDto;
import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import com.example.LMS.Models.entity.ClassId;
import com.example.LMS.Models.mappers.AttendanceMapper;
import com.example.LMS.Service.utils.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//http://localhost:8080/swagger-ui.html

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private AttendanceMapper attendanceMapper;


    // if there is no any data  >> return null
    @GetMapping("/all")
    public List<AttendanceDto> getAllAttendance() {
        List<Attendance> attendances = attendanceService.getAllAttendance();
        if (attendances != null) {
            return attendanceMapper.toDtoList(attendances);
        }
        return Collections.emptyList();
    }



//    @GetMapping("/get_by_id/{courseId}/{cycleId}/{classNo}/{studentId}")
//    public ResponseEntity<AttendanceIdDto> getAttendanceById(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
//        Optional<Attendance> attendance = attendanceService
//
//    }


    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{courseId}/{cycleId}/{classNo}/{studentId}")
    public void deleteAttendance(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
        attendanceService.deleteAttendance(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
    }
}