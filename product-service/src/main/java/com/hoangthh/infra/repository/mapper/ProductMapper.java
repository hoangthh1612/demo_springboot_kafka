package com.hoangthh.infra.repository.mapper;

import com.hoangthh.core.domain.ProductCore;
import com.hoangthh.infra.repository.db.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductMapper {
    public ProductCore toDomain(Product entity) {
        return ProductCore.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .quantity(entity.getQuantity())
                .build();

    }
    public List<ProductCore> toDomains(List<Product> entities) {
        List<ProductCore> result = new ArrayList<>();
        for (Product product : entities) {
            result.add(toDomain(product));
        }
        return result;
    }
    public Product toEntity(ProductCore productCore) {
        Product product = new Product();
        if(productCore.getId() != null) {
            product.setId(productCore.getId());
        }
        product.setDescription(productCore.getDescription());
        product.setQuantity(productCore.getQuantity());
        product.setPrice(productCore.getPrice());
        product.setName(productCore.getName());
        return product;
    }
    public Optional<ProductCore> toOptionalDomain(Optional<Product> entity) {
        if(entity.isPresent()) {
            Product product = entity.get();
            return Optional.of(ProductCore.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .description(product.getDescription())
                            .quantity(product.getQuantity())
                            .price(product.getPrice())
                    .build());
        }
        return Optional.empty();
    }
}
