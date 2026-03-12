package com.projekt.nartyBackend.Calendar.repositories;

import com.projekt.nartyBackend.Calendar.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}