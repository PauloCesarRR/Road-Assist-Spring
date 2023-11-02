package br.com.fiap.roadassist.model;

import java.time.LocalDate;


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
@Table(name = "tbl_winch")
public class WinchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

    @ManyToOne
	@JoinColumn(name = "winch_driver_id")
	private WinchDriverModel winchDriver;

    @ManyToOne
	@JoinColumn(name = "type_winch_id")
	private TypeWinchModel typeWinch;
}
