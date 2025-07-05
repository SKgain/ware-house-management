package com.waresafe.warehousemanagement.service;

import com.waresafe.warehousemanagement.entity.Schedule;
import com.waresafe.warehousemanagement.repository.ScheduleRepository;
import com.waresafe.warehousemanagement.requestDTO.ScheduleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
//    add schedule
    public void addSchedule(
            ScheduleRequestDTO scheduleDTO
    ){
        Schedule schedule = new Schedule();

        schedule
                .setDate(scheduleDTO.getDate());
        schedule
                .setTimeSlot(scheduleDTO.getTimeSlot());
        scheduleRepository
                .save(schedule);
    }
//    get all schedule
    public List<Schedule> getAllSchedule() {
        return
                scheduleRepository
                        .findAll();
    }
//    get schedule by id
    public Schedule getScheduleById(
            int id
    ){
        return
                scheduleRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Schedule Not Found"));
    }
//    update schedule
    public void updateSchedule(
            ScheduleRequestDTO scheduleDTO,
            int id
    ){
        Schedule schedule = scheduleRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Schedule Not Found"));
        schedule
                .setDate(scheduleDTO.getDate());
        schedule
                .setTimeSlot(scheduleDTO.getTimeSlot());
        scheduleRepository
                .save(schedule);
    }
//    delete schedule
    public void deleteSchedule(int id) {
        Schedule schedule = scheduleRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Schedule Not Found"));
        scheduleRepository
                .delete(schedule);
    }
}
