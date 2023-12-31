package br.com.fiap.roadassist.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_type_vehicle")
public class TypeVehicleModel {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqtypevehicle")
    @SequenceGenerator(name="seqtypevehicle", sequenceName="sequence_type_vehicle",initialValue=1,allocationSize=1)
    private Integer id;

    private String name;
}
