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
@Table(name = "tbl_address")
public class AddressModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
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
    
    @Column(name = "city_id")
    private UUID idCity;

}
