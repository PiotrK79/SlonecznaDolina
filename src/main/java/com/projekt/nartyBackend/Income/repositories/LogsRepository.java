package com.projekt.nartyBackend.Income.repositories;

import com.projekt.nartyBackend.Income.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Log, Long> {
}