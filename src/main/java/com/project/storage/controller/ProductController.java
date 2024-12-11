package com.project.storage.controller;

import com.project.storage.datasource.products.records.ProductsDetails;
import com.project.storage.datasource.products.records.ProductsRegister;
import com.project.storage.datasource.products.model.ProductsDataSource;
import com.project.storage.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductsRegister product) {
       productService.createProduct(product);
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductsDataSource>> ReadProducts(){
        return ResponseEntity.ok(productService.listarProdutos());
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ProductsRegister data){
        ProductsDataSource product = productService.buscarPorId(data.id());

        product.atualizarInformacoes(data);

        return ResponseEntity.ok(new ProductsDetails(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity

}
