package br.com.fiap.roadassist.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_type_vehicle")
public class TypeVehicleModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
}
