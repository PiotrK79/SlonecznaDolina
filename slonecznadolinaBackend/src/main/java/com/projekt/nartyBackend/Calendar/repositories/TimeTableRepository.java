package com.projekt.nartyBackend.Calendar.repositories;

import com.projekt.nartyBackend.Calendar.entities.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
}