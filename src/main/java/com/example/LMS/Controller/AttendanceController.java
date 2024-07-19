package com.example.LMS.Controller;


import com.example.LMS.Models.dto.AttendanceDto;
import com.example.LMS.Models.dto.AttendanceIdDto;
import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import com.example.LMS.Models.entity.ClassId;
import com.example.LMS.Models.mappers.AttendanceMapper;
import com.example.LMS.Service.utils.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
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


    @GetMapping("/all")
    public List<AttendanceDto> getAllAttendance() {
        List<Attendance> attendances = attendanceService.getAllAttendance();
        if (attendances != null) {
            for (Attendance attendance : attendances) {
                System.out.println("Processing Attendance: " + attendance);
                if (attendance.getId() == null) {
                    System.err.println("Attendance ID is null");
                } else if (attendance.getId().getClassId() == null) {
                    System.err.println("Class ID is null for Attendance ID: " + attendance.getId());
                } else {
                    System.out.println("Class ID: " + attendance.getId().getClassId());
                    System.out.println("Course ID: " + attendance.getId().getClassId().getCourseId());
                    System.out.println("Cycle ID: " + attendance.getId().getClassId().getCycleId());
                    System.out.println("Class No: " + attendance.getId().getClassId().getClassNo());
                }
            }
            return attendanceMapper.toDtoList(attendances);
        }
        return Collections.emptyList();
    }



    @GetMapping("/get_by_id/{courseId}/{cycleId}/{classNo}/{studentId}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
        if (attendance.isPresent()) {
            return ResponseEntity.ok(attendanceMapper.toDto(attendance.get()));
        }
        return ResponseEntity.notFound().build();
    }


    // return massage save successfully
    //use another endpoint to check the data already saved and return the massage
    @PostMapping("/save/{courseId}/{cycleId}/{classNo}/{studentId}")   // ?
    public AttendanceDto saveAttendance(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId  , @RequestBody AttendanceDto attendanceDto) {
       Attendance attendance = attendanceMapper.toEntity(attendanceDto);
       attendance.setId(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
        return attendanceMapper.toDto(attendanceService.saveAttendance(attendance));
    }



//
//    @PostMapping("/save/{courseId}/{cycleId}/{classNo}/{studentId}")
//    public ResponseEntity<String> saveAttendance( @PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @RequestBody AttendanceDto attendanceDto) {
//        Attendance attendance = attendanceMapper.toEntity(attendanceDto);
//        Attendance attendance1 = attendanceService.saveAttendance(attendance);
//        if (attendance1 != null) {
//            return new ResponseEntity<>("Save successfully", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("Save failed", HttpStatus.BAD_REQUEST);
//    }



    // ubdate
    @PutMapping("/update/{courseId}/{cycleId}/{classNo}/{studentId}")
    public ResponseEntity<AttendanceDto> updateAttendance(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId  ,  @RequestBody AttendanceDto attendanceDto) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
        if (attendance.isPresent()) {
            attendanceService.saveAttendance(attendanceMapper.toEntity(attendanceDto));
            return ResponseEntity.ok(attendanceMapper.toDto(attendance.get())); //  ..
        }
        return ResponseEntity.notFound().build();
    }

// return masseage delete successfully


    @DeleteMapping("/{courseId}/{cycleId}/{classNo}/{studentId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long courseId, @PathVariable Long cycleId, @PathVariable Long classNo, @PathVariable Long studentId) {
        Optional<Attendance> attendance = attendanceService.getAttendanceById(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
        if (attendance.isPresent()) {
            attendanceService.deleteAttendance(new AttendanceId(new ClassId(courseId, cycleId, classNo), studentId));
            return ResponseEntity.ok("delete successfully");
        }
        return ResponseEntity.notFound().build();
    }



}