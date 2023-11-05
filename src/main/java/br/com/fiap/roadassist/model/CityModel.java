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
@Table(name = "tbl_city")
public class CityModel {
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqcity")
    @SequenceGenerator(name="seqcity", sequenceName="sequence_city",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "name_city")
    private String name;

    @ManyToOne
	@JoinColumn(name = "state_id")
	private StateModel state;
}
