package com.hoangthh.core.service;

import com.hoangthh.core.domain.OrderCore;
import com.hoangthh.core.domain.ProductBody;
import com.hoangthh.infra.kafka.producer.OrderPublisher;
import com.hoangthh.infra.kafka.dto.EventOrder;
import com.hoangthh.infra.repository.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderProducer orderProducer;
    private final ProductClient productClient;
    private final OrderPublisher orderPublisher;

    public List<OrderCore> getAllOrders() {
        return orderProducer.getAllOrder();
    }
    public Optional<OrderCore> getOrderById(Long id) {
        Optional<OrderCore> order = orderProducer.getOrder(id);
        return order;
    }



    public String saveOrder(OrderCore order, ProductBody productBody) {
        if(checkAvalibility(productBody) == false) return "Product quantity not available.";
        if(order.getProductId() == 1L) {
            order.setVat("10");
        }
        else {
            order.setVat("20");
        }
        OrderCore orderCore = orderProducer.save(order);
        System.out.println(orderCore);
        CompletableFuture.runAsync(() -> {
            orderPublisher.sendMessageToTopic(createEventOrder(orderCore, productBody));
        });
        return "Order placed successfully";
    }

    public EventOrder createEventOrder(OrderCore order, ProductBody productBody) {
        String mail = "nguoitoiyeu16122000@gmail.com";
        Long userId = 16L;
        EventOrder eventOrder = new EventOrder();

        eventOrder.setOrderStatus(order.getOrderStatus());
        eventOrder.setProductName(productBody.getProductName());
        eventOrder.setPrice(order.getPrice());
        eventOrder.setQuantity(order.getQuantity());
        eventOrder.setVat(order.getVat());
        eventOrder.setMail(mail);
        eventOrder.setOrderId(order.getId());
        return eventOrder;
    }

    public Boolean checkAvalibility(ProductBody productBody) {
        return productClient.checkAvailability(productBody);
    }

}
