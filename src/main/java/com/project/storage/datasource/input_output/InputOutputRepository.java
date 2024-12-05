package com.project.storage.datasource.input_output;

import com.project.storage.datasource.input_output.model.InputOutputDataSource;
import com.project.storage.datasource.input_output.model.StatusEnum;
import com.project.storage.datasource.storage.model.StorageDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface InputOutputRepository extends JpaRepository<InputOutputDataSource, Integer> {

    Optional<InputOutputDataSource> findByIdOrder(Integer order);

    Optional<InputOutputDataSource> findByStorage(StorageDataSource storageDataSource);

    Optional<InputOutputDataSource> findByStatus(StatusEnum status);

    @Query("select u from InputOutputDataSource u where u.createAt between :dateMin and :dateMax")
    Optional<InputOutputDataSource> findByCreateAt(
            @Param("dateMin") LocalDateTime dateMin,
            @Param("dateMax") LocalDateTime dateMax);
}
