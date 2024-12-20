package com.project.storage.datasource.input_output.model;

import com.project.storage.datasource.storage.model.StorageDataSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "input_output")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InputOutputDataSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idOrder;
    private Boolean input;

    @ManyToOne
    @JoinColumn(name = "id_storage", referencedColumnName = "id")
    private StorageDataSource storage;
    private StatusEnum status;
    private LocalDateTime createAt;

    public InputOutputDataSource(InputOutputData data) {
        this.idOrder = data.idOrder();
        this.input = data.input();
        this.storage = data.storage();
        this.status = data.status();
        this.createAt = data.createAt();
    }

}
