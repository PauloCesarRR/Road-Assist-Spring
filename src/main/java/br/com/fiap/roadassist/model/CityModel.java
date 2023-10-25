package br.com.fiap.roadassist.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_city")
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name_city")
    private String name;

    @ManyToOne
	@JoinColumn(name = "city_state_fk")
	private StateModel state;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<AddressModel> addresses;
}
