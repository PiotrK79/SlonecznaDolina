package com.projekt.nartyBackend.repositories;

import com.projekt.nartyBackend.entities.DailyLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyLogsRepository extends JpaRepository<DailyLogs, Long> {
}