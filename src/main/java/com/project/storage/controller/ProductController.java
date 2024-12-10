package com.project.storage.controller;

import com.project.storage.datasource.products.model.ProductsData;
import com.project.storage.datasource.products.model.ProductsDataSource;
import com.project.storage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductsData product) {
       productService.createProduct(product);
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductsDataSource>> ReadProducts(){
        return ResponseEntity.ok(productService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid ProductsData data){
        var product = productService.buscarPorId(data.id());

    }

}
