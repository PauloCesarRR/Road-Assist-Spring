package br.com.fiap.roadassist.model;

import java.time.LocalDate;
import java.util.UUID;

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

    private Float weight;

    @ManyToOne
	@JoinColumn(name = "driver_id")
	private DriverModel driver;

    @ManyToOne
	@JoinColumn(name = "type_vehicle_id")
	private TypeVehicleModel typeVehicle;
}
