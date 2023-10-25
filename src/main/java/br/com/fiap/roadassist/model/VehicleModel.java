package br.com.fiap.roadassist.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_vehicle")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "license_plate")
    private String licensePlate;

    private LocalDate year;

    private Float height;

    private Float length;

    @Nullable
    private Float weight;

    @Column(name = "driver_id")
    private UUID idDriver;

    @Column(name = "type_vehicle_id")
    private UUID idTypeVehicle;

    @ManyToOne
	@JoinColumn(name = "vehicle_driver_fk")
	private DriverModel driver;

    @ManyToOne
	@JoinColumn(name = "vehicle_type_vehicle_fk")
	private TypeVehicleModel typeVehicle;
}
