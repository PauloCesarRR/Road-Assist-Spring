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
@Table(name = "tbl_city")
public class CityModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name_city")
    private String name;

    @Column(name = "state_id")
    private UUID idState;
}
