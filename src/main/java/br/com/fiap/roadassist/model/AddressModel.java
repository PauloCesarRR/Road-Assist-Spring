package br.com.fiap.roadassist.model;



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
@Table(name = "tbl_address")
public class AddressModel {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqaddress")
    @SequenceGenerator(name="seqaddress", sequenceName="sequence_address",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "home_number")
    private int number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "reference_point")
    private String referencePoint;

    @Column(name = "is_address")
    private String isAddress;
    
    @ManyToOne
	@JoinColumn(name = "city_id")
	private CityModel city;

}
