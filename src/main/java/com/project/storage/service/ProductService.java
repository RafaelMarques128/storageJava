package com.project.storage.service;

import com.project.storage.datasource.products.ProductsRepository;
import com.project.storage.datasource.products.records.ProductsRegister;
import com.project.storage.datasource.products.model.ProductsDataSource;
import com.project.storage.exception.ValidacaoException;
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
        if (product.brand() != null && product.model() != null && product.yearModel() != null && product.color() != null){
            productsRepository.save(ProductsDataSource.builder()
                    .brand(product.brand())
                    .model(product.model())
                    .yearModel(product.yearModel())
                    .color(product.color())
                    .fipe(product.fipe())
                    .build()
            );
        } else {
            throw new ValidacaoException("A marca, modelo, ano de modelo e cor");
        }
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
