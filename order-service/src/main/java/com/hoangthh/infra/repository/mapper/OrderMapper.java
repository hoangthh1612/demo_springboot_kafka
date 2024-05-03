package com.hoangthh.infra.repository.mapper;

import com.hoangthh.core.domain.OrderCore;
import com.hoangthh.infra.repository.db.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderMapper {
    public Order toEntity(OrderCore core) {
        Order order = new Order();
        order.setOrderStatus(core.getOrderStatus());
        order.setQuantity(core.getQuantity());
        order.setProductId(core.getProductId());
        order.setPrice(core.getPrice());
        order.setUserId(core.getUserId());

        return order;
    }
    public OrderCore toDomain(Order entity) {
        return OrderCore.builder()
                .userId(entity.getUserId())
                .id(entity.getId())
                .price(entity.getPrice())
                .orderStatus(entity.getOrderStatus())
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .build();
    }

    public List<OrderCore> toDomains(List<Order> entity) {
        List<OrderCore> result = new ArrayList<>();
        for(Order order : entity) {
//            return List.of(OrderCore.builder()
//                    .id(order.getId())
//                    .userId(order.getUserId())
//                    .price(order.getPrice())
//                    .productId(order.getProductId())
//                    .quantity(order.getQuantity())
//                    .orderStatus(order.getOrderStatus())
//                    .build());
            result.add(toDomain(order));

        }
        //return List.of();
        return result;
    }

    public Optional<OrderCore> toOptionalDomain(Optional<Order> entity) {
        if(entity.isPresent()) {
            Order order = entity.get();
            return Optional.of(OrderCore.builder()
                    .id(order.getId())
                    .userId(order.getUserId())
                    .price(order.getPrice())
                    .productId(order.getProductId())
                    .quantity(order.getQuantity())
                    .orderStatus(order.getOrderStatus())
                    .build());
        }
        return Optional.empty();
    }

}
