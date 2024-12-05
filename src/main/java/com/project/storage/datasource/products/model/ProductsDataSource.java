package com.project.storage.datasource.products.model;

import com.project.storage.datasource.storage.model.StorageDataSource;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductsDataSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String brand;

    private String model;

    private String yearModel;

    private String color;

    private Integer fipe;

}
