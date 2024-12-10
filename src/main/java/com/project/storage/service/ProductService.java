package com.project.storage.service;

import com.project.storage.datasource.products.ProductsRepository;
import com.project.storage.datasource.products.model.ProductsData;
import com.project.storage.datasource.products.model.ProductsDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    public void createProduct(ProductsData product) {
        productsRepository.save(ProductsDataSource.builder()
                .brand(product.brand())
                .model(product.model())
                .yearModel(product.yearModel())
                .color(product.color())
                .fipe(product.fipe())
                .build()
        );
    }

    public List<ProductsDataSource> listarProdutos() {
        List<ProductsDataSource> response = productsRepository.findAll();
        return response;
    }

    public Object buscarPorId(Integer id) {
        return productsRepository.findById(id);
    }

    public void updateProduct(ProductsData data) {

    }
}
