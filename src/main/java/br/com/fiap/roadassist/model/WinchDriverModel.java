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
@Table(name = "tbl_winch_driver")
public class WinchDriverModel {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqwinchdriver")
    @SequenceGenerator(name="seqwinchdriver", sequenceName="sequence_winch_driver",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
	@JoinColumn(name = "address_id")
	private AddressModel address;
}
