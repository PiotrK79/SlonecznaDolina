package com.projekt.nartyBackend.Income.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UploadEquipmentRequest {
    private String name;

    private BigDecimal price;
}
