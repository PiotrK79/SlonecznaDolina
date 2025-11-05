package com.projekt.nartyBackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;

@Entity
@Table(name = "karnety")
@Getter
@ToString
@Setter
public class Karnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int type;

    private BigDecimal price;
}
