package com.projekt.nartyBackend.Income.repositories;

import com.projekt.nartyBackend.Income.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}