package com.project.storage.datasource.products.model;

import org.springframework.http.ResponseEntity;

public record ProductsData(
        Integer id,
        String brand,
        String model,
        String yearModel,
        String color,
        Integer fipe
){}
