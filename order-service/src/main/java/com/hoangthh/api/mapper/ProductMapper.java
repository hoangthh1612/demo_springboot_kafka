package com.hoangthh.api.mapper;

import com.hoangthh.api.dto.request.ProductBodyRequest;
import com.hoangthh.core.domain.ProductBody;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductBody toDomain(ProductBodyRequest productBodyRequest) {
        ProductBody productBody = new ProductBody();
        productBody.setProductId(productBodyRequest.getProductId());
        productBody.setProductName(productBodyRequest.getProductName());
        productBody.setPrice(productBodyRequest.getPrice());
        productBody.setQuantity(productBodyRequest.getQuantity());

        return productBody;

    }
}
