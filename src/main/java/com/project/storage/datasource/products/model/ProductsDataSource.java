package com.project.storage.datasource.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductsDataSource {

    @Id
    @GeneratedValue
    private Integer id;

    private String brand;

    private String model;

    private String year;

    private String color;

    private Integer fipe;



}
