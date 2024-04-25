package com.hoangthh.controller;

import com.hoangthh.dto.EventOrder;
import com.hoangthh.dto.ProductBody;
import com.hoangthh.entity.Order;
import com.hoangthh.service.OrderProducer;
import com.hoangthh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderProducer orderProducer;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
       return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    //Middleware authorization => userId => parse to tranction id
    public ResponseEntity<String> createOrder(@RequestBody ProductBody productBody) {
        int userId = 5;
        String mail = "nguoitoiyeu16122000@gmail.com";
        ResponseEntity<Boolean> res = restTemplate.postForEntity("http://localhost:8082/api/product/check-availability", productBody, Boolean.class);
        Boolean isAvailable = res.getBody();
        if (isAvailable == false) {
            return ResponseEntity.ok("Order failed. Product quantity is not available.");
        }



        // save order into database
        Order order = new Order();
        order.setPrice(productBody.getPrice());
        order.setQuantity(productBody.getQuantity());
        order.setOrderStatus("PENDING");
        order.setUserId((long)userId);
        order.setProductId(productBody.getProductId());
        orderService.saveOrder(order);

        EventOrder eventOrder = new EventOrder();
        eventOrder.setOrderId(order.getId());
        eventOrder.setOrderStatus(order.getOrderStatus());
        eventOrder.setQuantity(order.getQuantity());
        eventOrder.setPrice(order.getPrice());
        eventOrder.setMail(mail);
        eventOrder.setProduct_name(productBody.getProduct_name());


        orderProducer.sendMessageToTopic(eventOrder);

        return ResponseEntity.ok("Order successfully created");
    }

}
