package com.projekt.nartyBackend.Calendar.repositories;

import com.projekt.nartyBackend.Calendar.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}