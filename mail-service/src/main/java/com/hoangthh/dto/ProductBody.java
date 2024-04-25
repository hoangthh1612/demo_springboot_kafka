package com.hoangthh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProductBody {
    private Long productId;
    private Long quantity;
    private String product_name;
    private Double price;

}
