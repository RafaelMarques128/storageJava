package com.project.storage.datasource.products.records;

import com.project.storage.datasource.products.model.ProductsDataSource;

public record ProductsDetails(
        Integer id,
        String brand,
        String model,
        String yearModel,
        String color,
        Integer fipe
){
    public ProductsDetails(ProductsDataSource products){
        this(
                products.getId(),
                products.getBrand(),
                products.getModel(),
                products.getYearModel(),
                products.getColor(),
                products.getFipe());
    }
}

