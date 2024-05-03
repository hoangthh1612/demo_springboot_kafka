package com.hoangthh.core.service;

import com.hoangthh.core.domain.ProductCore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductProducer {
    public List<ProductCore> getAllProducts();
    public ProductCore save(ProductCore productCore);
    public Optional<ProductCore> findById(Long id);
}
