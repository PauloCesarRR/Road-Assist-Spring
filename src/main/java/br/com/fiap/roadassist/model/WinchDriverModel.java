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

    @Column(length = 255, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String cpf;
}
