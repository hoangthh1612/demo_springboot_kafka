package com.hoangthh.infra.repository.db;

import com.hoangthh.infra.repository.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
