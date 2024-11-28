package com.project.storage.datasource.products;

import com.project.storage.datasource.input_output.model.InputOutputDataSource;
import com.project.storage.datasource.products.model.ProductsDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsDataSource, Integer> {

    Optional<ProductsDataSource> findByBrand(String brand);

    Optional<ProductsDataSource> findByModel(String model);

    @Query("select u from ProductsDataSource u where u.year between :yearMin and :yearMax")
    Optional<ProductsDataSource> findByYear(
            @Param("yearMin") String yearMin,
            @Param("yearMax") String yearMax);

    Optional<ProductsDataSource> findByColor(String color);

}
