package br.com.fiap.roadassist.model;

import java.util.UUID;

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
@Table(name = "tbl_compability_vehicle_winch")
public class CompatibilityVehicleWinchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
	@JoinColumn(name = "type_vehicle_fk")
	private TypeVehicleModel typeVehicle;

    @ManyToOne
	@JoinColumn(name = "type_vwinch_fk")
	private TypeWinchModel typeWinch;
}
