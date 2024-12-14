package com.project.storage.datasource.input_output.model;

import com.project.storage.datasource.storage.model.StorageDataSource;

import java.time.LocalDateTime;

public record InputOutputData(
    Integer idOrder,
    Boolean input,
    StorageDataSource storage,
    StatusEnum status,
    LocalDateTime createAt
) {}
