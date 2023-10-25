package br.com.fiap.roadassist.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_winch")
public class WinchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private LocalDate year;

    @Column(name = "height")
    private Float height;

    @Column(name = "length")
    private Float length;

    @Column(name = "winch_driver_id")
    private UUID idWinchDriver;

    @Column(name = "type_vehicle_id")
    private UUID idTypeVehicle;

}
