package com.hoangthh.infra.repository.service;

import com.hoangthh.core.domain.OrderCore;
import com.hoangthh.core.service.OrderProducer;
import com.hoangthh.infra.repository.db.OrderRepository;
import com.hoangthh.infra.repository.db.entity.Order;
import com.hoangthh.infra.repository.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderProducerImpl implements OrderProducer {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public Optional<OrderCore> getOrder(Long id) {
        return orderMapper.toOptionalDomain(orderRepository.findById(id));
    }

    @Override
    public List<OrderCore> getAllOrder() {
        return orderMapper.toDomains(orderRepository.findAll());
    }

    @Override
    public OrderCore save(OrderCore core) {
        //Order order = orderMapper.toEntity(orderCore);
        Order order = orderRepository.save(orderMapper.toEntity(core));
        OrderCore orderCore = orderMapper.toDomain(order);

        return orderCore;
    }

    @Override
    public OrderCore delete(OrderCore orderCore) {
        return null;
    }
}
