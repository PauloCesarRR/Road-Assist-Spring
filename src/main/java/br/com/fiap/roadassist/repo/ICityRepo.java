package br.com.fiap.roadassist.repo;


import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.CityModel;
import br.com.fiap.roadassist.model.StateModel;

public interface ICityRepo extends CrudRepository<CityModel, Integer>{
    CityModel findByNameAndStateContaining(String name, StateModel state);
}
