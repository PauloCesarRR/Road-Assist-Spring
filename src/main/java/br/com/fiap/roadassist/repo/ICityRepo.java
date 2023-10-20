package br.com.fiap.roadassist.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CityModel;

public interface ICityRepo extends JpaRepository<CityModel, UUID>{
    CityModel findByNameAndState(String name, UUID stateId);
}
