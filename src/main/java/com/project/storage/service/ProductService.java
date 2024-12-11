package com.project.storage.service;

import com.project.storage.datasource.products.ProductsRepository;
import com.project.storage.datasource.products.records.ProductsRegister;
import com.project.storage.datasource.products.model.ProductsDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductsRepository productsRepository;

    public void createProduct(ProductsRegister product) {
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

    public ProductsDataSource buscarPorId(Integer id) {
        return productsRepository.getReferenceById(id);
    }

    public void attProduct(Object product, ProductsRegister data) {

    }
}
