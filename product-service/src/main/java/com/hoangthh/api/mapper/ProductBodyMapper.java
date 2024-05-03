package com.hoangthh.api.mapper;

import com.hoangthh.api.dto.request.ProductBodyRequest;
import com.hoangthh.core.domain.ProductBody;
import org.springframework.stereotype.Component;


@Component
public class ProductBodyMapper {

    public ProductBody toDomain(ProductBodyRequest request) {
        ProductBody productBody = new ProductBody();
        productBody.setProductId(request.getProductId());
        productBody.setProductName(request.getProductName());
        productBody.setPrice(request.getPrice());
        productBody.setQuantity(request.getQuantity());
        return productBody;
    }
}
