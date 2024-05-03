package com.hoangthh.core.service;

import com.hoangthh.core.domain.OrderCore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrderProducer {
    Optional<OrderCore> getOrder(Long id);
    List<OrderCore> getAllOrder();
    OrderCore save(OrderCore orderCore);
    OrderCore delete(OrderCore orderCore);
}
