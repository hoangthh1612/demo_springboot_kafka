package com.hoangthh.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderCore {
    private Long id;
    private Long userId;
    private Long productId;
    private Long quantity;
    private double price;
    private String orderStatus;
    private String vat;

    public static OrderCore from(ProductBody productBody) {
        OrderCore orderCore = new OrderCore();
        orderCore.setPrice(productBody.getPrice());
        orderCore.setQuantity(productBody.getQuantity());
        orderCore.setProductId(productBody.getProductId());
        orderCore.setOrderStatus("PENDING");

        return orderCore;
    }
}
