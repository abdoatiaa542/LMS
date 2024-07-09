package com.example.LMS.Service.imp;

import com.example.LMS.Models.entity.Attendance;
import com.example.LMS.Models.entity.AttendanceId;
import com.example.LMS.Reposatory.AttendanceRepository;
import com.example.LMS.Service.utils.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // create getAttendanceById method

    @Override
    public Optional<Attendance> getAttendanceById(AttendanceId attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }
    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendance(AttendanceId attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }
}