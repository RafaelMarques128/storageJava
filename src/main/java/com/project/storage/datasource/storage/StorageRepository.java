package com.project.storage.datasource.storage;

import com.project.storage.datasource.products.model.ProductsDataSource;
import com.project.storage.datasource.storage.model.StorageDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<StorageDataSource, Integer> {

    Optional<StorageDataSource> findByEin(String ein);

    Optional<StorageDataSource> findByProduct(ProductsDataSource product);

    Optional<StorageDataSource> findByEnabled(Boolean enabled);

    @Query("select u from StorageDataSource u where u.createAt between :startDate and :endDate")
    Optional<StorageDataSource> findByCreateAt(
            @Param("startDate") LocalDateTime createAt,
            @Param("endDate") LocalDateTime endDate);

    Optional<StorageDataSource> findByLastUpdateAt(LocalDateTime lastUpdateAt);

    Optional<StorageDataSource> findByCloseAt(LocalDateTime closeAt);

}
