package com.hoangthh.api.mapper;

import com.hoangthh.api.dto.request.ProductRequest;
import com.hoangthh.core.domain.ProductCore;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper {
    public ProductCore toDomain(ProductRequest productRequest) {
        ProductCore productCore = new ProductCore();
        productCore.setQuantity(productRequest.getQuantity());
        productCore.setPrice(productRequest.getPrice());
        productCore.setDescription(productRequest.getDescription());
        productCore.setName(productRequest.getName());
        return productCore;
    }
}
