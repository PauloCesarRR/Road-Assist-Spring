package br.com.fiap.roadassist.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_vehicle")
public class VehicleModel {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqvehicle")
    @SequenceGenerator(name="seqvehicle", sequenceName="sequence_vehicle",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "license_plate")
    private String licensePlate;

    private LocalDate year;

    private String categoria_tarifaria;

    private String marca;

    private String cor;

    private String modelo;

    private String carroceria;

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
