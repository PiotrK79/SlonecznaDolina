package com.projekt.nartyBackend.repositories;

import com.projekt.nartyBackend.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}