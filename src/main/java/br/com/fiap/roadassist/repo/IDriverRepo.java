package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.DriverModel;

public interface IDriverRepo extends CrudRepository<DriverModel, Integer>{
    DriverModel findByEmail(String email);
}
