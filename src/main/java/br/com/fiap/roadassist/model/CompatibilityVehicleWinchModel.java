package br.com.fiap.roadassist.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_type_vehicle")
public class CompatibilityVehicleWinchModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name="type_winch_id")
    private UUID typeWinch;

    @Column(name="type_vehicle_id")
    private UUID typeVehicle;
}
