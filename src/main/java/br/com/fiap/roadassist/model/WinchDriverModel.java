package br.com.fiap.roadassist.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_winch_driver")
public class WinchDriverModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "active")
    private boolean active;

    @Column(name = "address_id")
    private UUID addressId;
}
