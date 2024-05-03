package com.hoangthh.infra.repository.db.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private Long quantity;

}

