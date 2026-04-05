package com.projekt.nartyBackend.Calendar.repositories;

import com.projekt.nartyBackend.Auth.Entities.User;
import com.projekt.nartyBackend.Calendar.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    public List<Event> findAllByUser(User user);
}