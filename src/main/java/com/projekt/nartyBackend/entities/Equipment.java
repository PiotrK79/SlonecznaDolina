package com.projekt.nartyBackend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Equipment")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal price;
}
