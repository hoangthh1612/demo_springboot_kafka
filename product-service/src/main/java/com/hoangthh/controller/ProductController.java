package com.hoangthh.controller;


import com.hoangthh.dto.ProductBody;
import com.hoangthh.entity.Product;
import com.hoangthh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.createProduct(product));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @PostMapping("/check-availability")
    public ResponseEntity<Boolean> checkAvailability(@RequestBody ProductBody productBody) {
        Boolean availability = productService.checkAvailability(productBody);
        if(!availability) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

}
