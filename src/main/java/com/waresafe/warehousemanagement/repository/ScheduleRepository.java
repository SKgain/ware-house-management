package com.waresafe.warehousemanagement.repository;

import com.waresafe.warehousemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
