package com.project.storage.datasource.products.records;

import com.project.storage.datasource.products.model.ProductsDataSource;

public record ProductsDataList(
        Integer id,
        String brand,
        String model,
        String yearModel,
        String color,
        Integer fipe
) {
    public ProductsDataList(ProductsDataSource product) {
        this(product.getId(), product.getBrand(), product.getModel(), product.getYearModel(), product.getColor(), product.getFipe());
    }
}
