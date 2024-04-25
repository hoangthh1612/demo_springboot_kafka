package com.hoangthh.infra.consume.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventOrder {
    private Long orderId;
    private String mail;
    private String product_name;
    private Long quantity;
    private Double price;
    private String orderStatus;
}
