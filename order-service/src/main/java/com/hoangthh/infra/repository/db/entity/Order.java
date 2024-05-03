package com.hoangthh.infra.repository.db.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long productId;

    @Column
    private Long quantity;

    @Column
    private Double price;

    @Column
    private String orderStatus;

}
