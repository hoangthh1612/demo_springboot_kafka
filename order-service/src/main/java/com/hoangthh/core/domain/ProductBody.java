package com.hoangthh.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBody {
    private Long productId;
    private Long quantity;
    private String productName;
    private Double price;

}
