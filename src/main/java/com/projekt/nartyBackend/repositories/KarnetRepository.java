package com.projekt.nartyBackend.repositories;

import com.projekt.nartyBackend.entities.Karnet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KarnetRepository extends JpaRepository<Karnet, Long> {
}