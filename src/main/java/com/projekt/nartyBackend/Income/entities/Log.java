package com.projekt.nartyBackend.Income.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "Logs")
@Entity
@Getter
@Setter
@ToString//
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "log_date")
    private LocalDateTime date;

    private int quantity;

    private BigDecimal totalPrice;

    @ManyToOne()
    @JoinColumn(name = "equipment_id")
     private Equipment  equipment;

}
