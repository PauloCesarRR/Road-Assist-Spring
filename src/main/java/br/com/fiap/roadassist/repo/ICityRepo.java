package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CityModel;
import br.com.fiap.roadassist.model.StateModel;

public interface ICityRepo extends JpaRepository<CityModel, UUID>{
    CityModel findByNameAndStateContaining(String name, StateModel state);
}
