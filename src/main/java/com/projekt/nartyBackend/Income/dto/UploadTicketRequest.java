package com.projekt.nartyBackend.Income.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
public class UploadTicketRequest {
    private int equipmentId;
    private BigDecimal price;
}
