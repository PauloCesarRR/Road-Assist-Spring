package br.com.fiap.roadassist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_state")
public class StateModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqstate")
    @SequenceGenerator(name="seqstate", sequenceName="sequence_state",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "name_state")
    private String name;
}
