package com.project.storage.datasource.products.records;

public record ProductsRegister(
        Integer id,
        String brand,
        String model,
        String yearModel,
        String color,
        Integer fipe
){}
