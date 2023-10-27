package br.com.fiap.roadassist.model;



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
@Table(name = "tbl_winch_driver")
public class WinchDriverModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
	@JoinColumn(name = "address_id")
	private AddressModel address;
}
