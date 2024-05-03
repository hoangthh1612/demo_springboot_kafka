package com.hoangthh.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBodyRequest {
    private Long productId;
    private Long quantity;
    private String productName;
    private Double price;

}
