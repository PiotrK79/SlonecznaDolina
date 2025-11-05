package com.projekt.nartyBackend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;


@Table
@Entity
public class DailyLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Time date;

    private int quantity;

    private BigDecimal totalPrice;

    private type logType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Karnet karnet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Equipment  equipment;

}
