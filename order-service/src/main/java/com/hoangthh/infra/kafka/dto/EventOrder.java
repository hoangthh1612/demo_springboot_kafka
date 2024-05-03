package com.hoangthh.infra.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class EventOrder {
    private Long orderId;
    private String mail;
    private String productName;
    private Long quantity;
    private Double price;
    private String orderStatus;
    private String vat;


}
