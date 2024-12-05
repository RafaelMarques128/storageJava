package com.project.storage.datasource.storage.model;

import com.project.storage.datasource.products.model.ProductsDataSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "storage")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StorageDataSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ein;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private ProductsDataSource product;

    private Integer quantity;

    private String description;

    private Integer min;

    private Integer max;

    private Boolean enabled;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdateAt;

    private LocalDateTime closeAt;

    private Double price;

}
