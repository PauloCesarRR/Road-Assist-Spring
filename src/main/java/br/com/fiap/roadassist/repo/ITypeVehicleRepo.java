package br.com.fiap.roadassist.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.roadassist.model.TypeVehicleModel;

public interface ITypeVehicleRepo extends CrudRepository<TypeVehicleModel, Integer>{
    TypeVehicleModel findByName(String name);
}
