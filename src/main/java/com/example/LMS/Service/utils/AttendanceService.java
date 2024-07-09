package com.example.LMS.Service.utils;



import java.util.List;
import java.util.Optional;

import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;

public interface AttendanceService {

    List<Attendance> getAllAttendance();
    Optional<Attendance> getAttendanceById(AttendanceId attendanceId);
    Attendance saveAttendance(Attendance attendance);
    void deleteAttendance(AttendanceId attendanceId);

}