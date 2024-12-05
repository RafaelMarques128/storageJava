package com.project.storage.datasource.input_output.model;

import lombok.Getter;

@Getter
public enum StatusEnum {

    PENDING("pendente"),
    APPROVED("aprovado"),
    FAILED("reprovado");

    private String description;

    StatusEnum(String describe) {
        this.description = describe;
    }

}
