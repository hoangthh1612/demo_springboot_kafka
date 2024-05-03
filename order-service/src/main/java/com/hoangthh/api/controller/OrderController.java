package com.hoangthh.api.controller;

import com.hoangthh.api.dto.request.ProductBodyRequest;
import com.hoangthh.api.mapper.ProductMapper;
import com.hoangthh.core.domain.OrderCore;
import com.hoangthh.core.exception.ServerSideException;
import com.hoangthh.core.domain.ProductBody;

import com.hoangthh.core.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final ProductMapper productMapper;

    @GetMapping("")
    public List<OrderCore> getAllOrders() {
        //return orderService.getAllOrders();
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<OrderCore> getOrderById(@PathVariable Long id) {
       return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    //Middleware authorization => userId => parse to tranction id
    public ResponseEntity<String> createOrder(@RequestBody ProductBodyRequest request) {

        try {
            ProductBody productBody = productMapper.toDomain(request);

            OrderCore orderCore = OrderCore.from(productBody);
            String message = orderService.saveOrder(orderCore, productBody);
            return ResponseEntity.ok(message);

        }
        catch (ServerSideException serverSideException) {
            return ResponseEntity.ok(serverSideException.getInternalMessage());
        }
        catch (Exception e) {
            //log.error(e);
            log.error("Internal server error", e);
            return ResponseEntity.ok("Internal server error");
        }

        // save order into database


    }

}
