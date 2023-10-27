package br.com.fiap.roadassist.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.roadassist.model.CityModel;
import br.com.fiap.roadassist.model.StateModel;

public interface ICityRepo extends JpaRepository<CityModel, Integer>{
    CityModel findByNameAndStateContaining(String name, StateModel state);
}
