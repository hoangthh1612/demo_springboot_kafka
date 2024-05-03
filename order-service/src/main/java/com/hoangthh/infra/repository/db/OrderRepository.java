package com.hoangthh.infra.repository.db;

import com.hoangthh.infra.repository.db.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
