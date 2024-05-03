package com.hoangthh.api.controller;


import com.hoangthh.api.dto.request.ProductBodyRequest;
import com.hoangthh.api.dto.request.ProductRequest;
import com.hoangthh.api.mapper.ProductBodyMapper;
import com.hoangthh.api.mapper.ProductRequestMapper;
import com.hoangthh.core.domain.ProductBody;
import com.hoangthh.core.domain.ProductCore;
import com.hoangthh.infra.repository.db.entity.Product;
import com.hoangthh.core.service.ProductService;
import com.hoangthh.infra.repository.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {


    private final ProductService productService;
    private final ProductRequestMapper productRequestMapper;
    private final ProductBodyMapper productBodyMapper;
    @GetMapping("")
    public ResponseEntity<List<ProductCore>> getAllProducts() {
        List<ProductCore> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        ProductCore productCore = productRequestMapper.toDomain(request);
        return ResponseEntity.ok(productService.save(productCore));
    }
    @PostMapping("/check-availability")
    public ResponseEntity<Boolean> checkAvailability(@RequestBody ProductBodyRequest request) {
        ProductBody productBody = productBodyMapper.toDomain(request);
        System.out.println(productBody);
        Boolean availability = productService.checkAvailability(productBody);
        if(!availability) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

}
