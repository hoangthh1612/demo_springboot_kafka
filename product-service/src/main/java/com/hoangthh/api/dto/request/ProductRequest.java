package com.hoangthh.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Long quantity;
}
