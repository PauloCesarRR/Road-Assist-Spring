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
@Table(name = "tbl_state")
public class StateModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "name_state")
    private String name;
}