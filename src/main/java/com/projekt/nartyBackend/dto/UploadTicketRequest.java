package com.projekt.nartyBackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
public class UploadTicketRequest {
    private int type;
    private BigDecimal price;
}
