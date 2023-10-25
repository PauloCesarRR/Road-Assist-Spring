package br.com.fiap.roadassist.model;

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
@Table(name = "tbl_winch_driver")
public class WinchDriverModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private long cpf;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
	@JoinColumn(name = "winch_driver_address_fk")
	private AddressModel address;
}
