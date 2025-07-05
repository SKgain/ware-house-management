package com.waresafe.warehousemanagement.controller;

import com.waresafe.warehousemanagement.entity.Schedule;
import com.waresafe.warehousemanagement.requestDTO.ScheduleRequestDTO;
import com.waresafe.warehousemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
//    add achedule
    @PostMapping("/add-schedule")
    public ResponseEntity<String> addSchedule(
            @RequestBody ScheduleRequestDTO scheduleDTO
    ) {
        scheduleService
                .addSchedule(scheduleDTO);
        return
                ResponseEntity
                        .ok("Schedule added successfully");
    }

//    Get schedule
    @GetMapping("/get-all-schedule")
    public List<Schedule> getAllSchedule() {
        return
                scheduleService
                        .getAllSchedule();
    }
//    Get schedule by id
    @GetMapping("/get-schedule/{id}")
    public Schedule getScheduleById(
            @PathVariable int id
    ){
        return
                scheduleService
                        .getScheduleById(id);
    }
//    update schedule
    @PutMapping("/update-schedule/{id}")
    public ResponseEntity<String> updateSchedule(
            @RequestBody ScheduleRequestDTO scheduleDTO,
            @PathVariable int id
    ){
        scheduleService
                .updateSchedule(scheduleDTO,id);
        return
                ResponseEntity
                        .ok("Schedule updated successfully");
    }
//    delete schedule
    @DeleteMapping("/delete-schedule/{id}")
    public ResponseEntity<String> deleteSchedule(
            @PathVariable int id
    ){
        scheduleService
                .deleteSchedule(id);
        return
                ResponseEntity
                        .ok("Schedule deleted successfully");
    }
}
