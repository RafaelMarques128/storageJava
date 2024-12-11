package com.project.storage.datasource.products.model;

import com.project.storage.datasource.products.records.ProductsRegister;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String brand;

    private String model;

    private String yearModel;

    private String color;

    private Integer fipe;

    public ProductsDataSource(ProductsRegister data) {
        this.brand = data.brand();
        this.model = data.model();
        this.yearModel = data.yearModel();
        this.color = data.color();
        this.fipe = data.fipe();
    }

    public void atualizarInformacoes(ProductsRegister productsRegister){
        if (productsRegister.brand() != null) {
            this.brand = productsRegister.brand();
        }
        if (productsRegister.model() != null) {
            this.model = productsRegister.model();
        }
        if (productsRegister.yearModel() != null) {
            this.yearModel = productsRegister.yearModel();
        }
        if (productsRegister.color() != null){
            this.color = productsRegister.color();
        }
        if (productsRegister.fipe() != null){
            this.fipe = productsRegister.fipe();
        }
    }

}
