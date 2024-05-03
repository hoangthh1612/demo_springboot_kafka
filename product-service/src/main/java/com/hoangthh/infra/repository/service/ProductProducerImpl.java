package com.hoangthh.infra.repository.service;

import com.hoangthh.core.domain.ProductCore;
import com.hoangthh.core.service.ProductProducer;
import com.hoangthh.infra.repository.db.ProductRepository;
import com.hoangthh.infra.repository.db.entity.Product;
import com.hoangthh.infra.repository.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductProducerImpl implements ProductProducer {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductCore> getAllProducts() {
        return productMapper.toDomains(productRepository.findAll());
    }
    public ProductCore save(ProductCore productCore) {
        Product product = productRepository.save(productMapper.toEntity(productCore));
        return productMapper.toDomain(product);
    }

    @Override
    public Optional<ProductCore> findById(Long id) {
        return productMapper.toOptionalDomain(productRepository.findById(id));
    }
}
