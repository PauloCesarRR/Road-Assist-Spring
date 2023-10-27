package br.com.fiap.roadassist.model;



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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
	@JoinColumn(name = "type_vehicle_id")
	private TypeVehicleModel typeVehicle;

    @ManyToOne
	@JoinColumn(name = "type_winch_id")
	private TypeWinchModel typeWinch;
}
